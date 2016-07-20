package org.itstep.prokopchik.cricova.command;

//«хранилище» команд
public enum CommandEnum {

    TO_LOGIN_PAGE {
        {
            this.command = new ToLoginPage();
        }
    },

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },

    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },

    RECEIVE_PRICE {
        {
            this.command = new SenderCommand();
        }
    },

    NO_REGISTRATION {
        {
            this.command = new NoRegistrationCommand();
        }
    },

    CHANGE_USER_INFO {
        {
            this.command = new ChangeUserInfoCommand();
        }
    },

    USER_OFFICE {
        {
            this.command = new UserOfficeCommand();
        }
    },

    NEW_CLIENT {
        {
            this.command = new NewClientCommand();
        }
    };


    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
