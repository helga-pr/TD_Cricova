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

    TO_ADMINISTRATION_PAGE {
        {
            this.command = new ToAdministrationPageCommand();
        }
    },

    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },

    ADD_PRODUCT {
        {
            this.command = new AddProductCommand();
        }
    },


    CHANGE_PRODUCT {
        {
            this.command = new ChangeProductCommand();
        }
    },

    DELETE_PRODUCT {
        {
            this.command = new DeleteProductCommand();
        }
    },

    SHOW_PRICE {
        {
            this.command = new ShowPriceCommand();
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

    CHANGE_USER_NAME {
        {
            this.command = new UserOfficeChangeNameCommand();
        }
    },

    CHANGE_USER_PASSWORD {
        {
            this.command = new UserOfficeChangePasswordCommand();
        }
    },

    CHANGE_USER_CONTACTS {
        {
            this.command = new UserOfficeChangeContactsCommand();
        }
    },

    CHANGE_COMPANY_NOTES {
        {
            this.command = new UserOfficeChangeCompanyNotesCommand();
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
