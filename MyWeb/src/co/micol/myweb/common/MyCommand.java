package co.micol.myweb.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyCommand {
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
