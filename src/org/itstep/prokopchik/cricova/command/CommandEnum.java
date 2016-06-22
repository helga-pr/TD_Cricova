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

    NO_REGISTRATION {
        {
            this.command = new NoRegistrationCommand();
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
