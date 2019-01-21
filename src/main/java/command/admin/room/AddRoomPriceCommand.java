package command.admin.room;

import command.Command;
import command.CommandResult;
import exception.ServiceException;
import service.RoomPriceService;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Designed to add price for room.
 */

public class AddRoomPriceCommand implements Command {

    private static final String ROOM_PRICES_PAGE = "controller?command=showRoomPrices&roomId=";
    private static final String ERROR_PAGE = "/WEB-INF/pages/error/Error404.jsp";
    private static final String ROOM_LIMIT = "&roomLimit=";
    private static final String ROOM_PAGE = "&roomPage=";
    private static final String ROOM_ID = "roomId";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String COST = "cost";
    private static final String LIMIT = "limit";
    private static final String PAGE = "roomPage";
    private static final String MESSAGE = "&message=";
    private static final String ADD_PRICE = "addPrice";
    private static final String INVALID_DATA = "invalidData";

    /**
     * Process the request, add price for room and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String stringRoomId = request.getParameter(ROOM_ID);
        String stringStartDate = request.getParameter(START_DATE);
        String stringEndDate = request.getParameter(END_DATE);
        String stringCost = request.getParameter(COST);

        String limit = request.getParameter(LIMIT);
        String page = request.getParameter(PAGE);

        Validation validation = new Validation();
        Map<String, String> pageData = new HashMap<>();
        pageData.put(LIMIT, limit);
        pageData.put(PAGE, page);
        if (!validation.isValidData(pageData)) {
            return CommandResult.forward(ERROR_PAGE);
        }

        Map<String, String> inputData = new HashMap<>();
        inputData.put(ROOM_ID, stringRoomId);
        inputData.put(COST, stringCost);

        if (!validation.isValidData(inputData)) {
            return CommandResult.redirect(ROOM_PRICES_PAGE + stringRoomId + ROOM_LIMIT + limit
                    + ROOM_PAGE + page + MESSAGE + INVALID_DATA);
        }

        Integer roomId = Integer.parseInt(stringRoomId);

        Date startDate = Date.valueOf(stringStartDate);
        Date endDate = Date.valueOf(stringEndDate);

        BigDecimal cost = new BigDecimal(stringCost);

        RoomPriceService roomPriceService = new RoomPriceService();
        roomPriceService.addPrice(null, roomId, startDate, endDate, cost);

        return CommandResult.redirect(ROOM_PRICES_PAGE + stringRoomId + ROOM_LIMIT + limit
                + ROOM_PAGE + page + MESSAGE + ADD_PRICE);
    }
}
