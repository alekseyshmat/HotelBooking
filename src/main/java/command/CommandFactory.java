package command;

import command.admin.*;
import command.admin.order.AdminOrderCommand;
import command.admin.order.AdminStartPageCommand;
import command.admin.order.CompleteOrderCommand;
import command.admin.order.ProcessOrderCommand;
import command.admin.room.*;
import command.user.*;

public class CommandFactory {

    private static final String LOGIN = "login";
    private static final String SHOW_PROFILE = "showProfile";
    private static final String SHOW_ORDERS = "showOrders";
    private static final String SHOW_ALL_ORDERS = "showAllOrders";
    private static final String SHOW_USERS = "showUsers";
    private static final String SHOW_ROOMS = "showRooms";
    private static final String SHOW_ROOM_PRICES = "showRoomPrices";
    private static final String SHOW_BALANCE = "showBalance";
    private static final String REFILE_BALANCE = "refileBalance";
    private static final String MAIN_PAGE = "mainPage";
    private static final String ADMIN_MAIN_PAGE = "adminPage";
    private static final String MAKE_ORDER = "makeOrder";
    private static final String PROCESS_ORDER = "processOrder";
    private static final String COMPLETE_ORDER = "completeOrder";
    private static final String CANCEL_ORDER = "cancelOrder";
    private static final String UPDATE_BALANCE = "updateBalance";
    private static final String CHANGE_LANGUAGE = "changeLanguage";
    private static final String SAVE_ROOM = "saveRoom";
    private static final String ADD_ROOM_PRICE = "addRoomPrice";
    private static final String LOG_OUT = "signOut";
    private static final String EDIT_PROFILE = "editProfile";
    private static final String SEARCH_ROOM_BY_CRITERIA = "searchRoomByCriteria";
    private static final String CHANGE_BLOCKING_STATUS = "changeBlockingStatus";
    private static final String START_PAGE = "startPage";

    public Command create(String command) {
        switch (command) {
            case LOGIN:
                return new LoginCommand();
            case SHOW_PROFILE:
                return new ProfileCommand();
            case SHOW_ORDERS:
                return new OrderCommand();
            case SHOW_ALL_ORDERS:
                return new AdminOrderCommand();
            case SHOW_USERS:
                return new UserCommand();
            case SHOW_ROOMS:
                return new RoomCommand();
            case SHOW_ROOM_PRICES:
                return new RoomPricesCommand();
            case SHOW_BALANCE:
                return new BalanceCommand();
            case REFILE_BALANCE:
                return new RefileBalanceCommand();
            case MAIN_PAGE:
                return new MainPageCommand();
            case ADMIN_MAIN_PAGE:
                return new AdminStartPageCommand();
            case MAKE_ORDER:
                return new MakeOrderCommand();
            case PROCESS_ORDER:
                return new ProcessOrderCommand();
            case COMPLETE_ORDER:
                return new CompleteOrderCommand();
            case CANCEL_ORDER:
                return new CancelOrderCommand();
            case UPDATE_BALANCE:
                return new PayOrderCommand();
            case CHANGE_LANGUAGE:
                return new ChangeLanguageCommand();
            case SAVE_ROOM:
                return new SaveRoomCommand();
            case ADD_ROOM_PRICE:
                return new AddRoomPriceCommand();
            case LOG_OUT:
                return new LogOutCommand();
            case EDIT_PROFILE:
                return new EditProfileCommand();
            case SEARCH_ROOM_BY_CRITERIA:
                return new SearchRoomByCriteria();
            case CHANGE_BLOCKING_STATUS:
                return new ChangeBlockingStatus();
            case START_PAGE:
                return new StartPageCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
