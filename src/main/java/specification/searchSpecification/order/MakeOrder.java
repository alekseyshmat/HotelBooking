package specification.searchSpecification.order;

import entity.types.PaymentType;
import entity.types.PlaceType;
import entity.types.RoomType;
import specification.Specification;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MakeOrder implements Specification {

    private int idClient;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private RoomType roomType;
    private PlaceType placeType;
    private PaymentType paymentType;

    public MakeOrder(int idClient, LocalDate checkInDate, LocalDate checkOutDate,
                     RoomType roomType, PlaceType placeType, PaymentType paymentType) {
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.placeType = placeType;
        this.paymentType = paymentType;
    }

    @Override
    public String toSql() {
        return "VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(idClient, checkInDate, checkOutDate, roomType, placeType, paymentType);
    }
}
