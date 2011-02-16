package ktaiquiz;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import ktaiquiz.dto.ConditionDto;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;


public class InitPlugIn implements PlugIn {

	public void destroy() {}

	@Override
	public void init(ActionServlet actionServlet, ModuleConfig config)
			throws ServletException {

		ServletContext application = actionServlet.getServletContext();
		ConditionDto conditionDto = new ConditionDto();
		try {
			initStatus(application, conditionDto);
		} catch (Exception e) {
			throw new ServletException(e); 
		}
		application.setAttribute("conditionDto", conditionDto);
	}
	
	static public void initStatus(ServletContext application, ConditionDto conditionDto) throws InvalidPropertiesFormatException, IOException {
		Properties p = new Properties();
		p.loadFromXML( InitPlugIn.class.getClassLoader().getResourceAsStream( "settings.xml" ) ); 

		// 状態を初期化
		conditionDto.init(p);
	}
}