package command;

import command.admin.*;
import command.user.BalanceCommand;
import command.user.MakeOrderCommand;
import command.user.OrderCommand;

public class CommandFactory {

    public Command create(String command) {
        switch (command) {
            case "login":
                return new LoginCommand();
            case "showProfile":
                return new ProfileCommand();
            case "showOrders":
                return new OrderCommand();
            case "showAllOrders":
                return new AdminOrderCommand();
            case "showUsers":
                return new UserCommand();
            case "showRooms":
                return new RoomCommand();
            case "showRoomPrices":
                return new RoomPricesCommand();
            case "showBalance":
                return new BalanceCommand();
            case "makeOrder":
                return new MakeOrderCommand();
            case "changeLanguage":
                return new ChangeLanguageCommand();
            case"addRoom":
                return new AddRoomCommand();
            case"addRoomPrice":
                return new AddRoomPriceCommand();
            case "signOut":
                return new SignOutCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
