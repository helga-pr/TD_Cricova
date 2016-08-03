package org.itstep.prokopchik.cricova.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//интерфейс, определяющий контракт и его реализации

public interface ActionCommand {

    String execute(HttpServletRequest request) throws IOException, ServletException;
}
