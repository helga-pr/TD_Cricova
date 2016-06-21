package org.itstep.prokopchik.cricova.command;

import javax.servlet.http.HttpServletRequest;

//интерфейс, определяющий контракт и его реализации

public interface ActionCommand {

    String execute(HttpServletRequest request);
}
