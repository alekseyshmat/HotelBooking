package command;

import command.admin.RoomCommand;
import command.admin.RoomPricesCommand;
import command.admin.UserCommand;
import command.user.BalanceCommand;
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
            case "showUsers":
                return new UserCommand();
            case "showRooms":
                return new RoomCommand();
            case "showRoomPrices":
                return new RoomPricesCommand();
            case "showBalance":
                return new BalanceCommand();
            case "signOut":
                return new SignOutCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}