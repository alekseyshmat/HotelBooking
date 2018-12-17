package command;

import command.admin.*;
import command.admin.order.AdminOrderCommand;
import command.admin.order.CompleteOrderCommand;
import command.admin.order.ProcessOrderCommand;
import command.admin.room.*;
import command.user.*;

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
            case "refileBalance":
                return new RefileBalanceCommand();
            case "mainPage":
                return new MainPageCommand();
            case "makeOrder":
                return new MakeOrderCommand();
            case "processOrder":
                return new ProcessOrderCommand();
            case "completeOrder":
                return new CompleteOrderCommand();
            case "updateBalance":
                return new PayOrderCommand();
            case "changeLanguage":
                return new ChangeLanguageCommand();
            case"saveRoom":
                return new SaveRoomCommand();
            case"addRoomPrice":
                return new AddRoomPriceCommand();
            case "signOut":
                return new SignOutCommand();
            case "editProfile":
                return new EditProfileCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
