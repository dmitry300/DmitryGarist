package by.training.barbershop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class PagesTag extends TagSupport {
    private static final Logger log = LogManager.getLogger();
    private String pagesCountAttribute;
    private String command;

    public void setPagesCountAttribute(String pageCountAttribute) {
        this.pagesCountAttribute = pageCountAttribute;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public int doStartTag() throws JspException {
        int pageCount;
        try {
            pageCount = Integer.parseInt(pagesCountAttribute);
        } catch (NumberFormatException e) {
            log.error("Illegal attribute value {}", e.getMessage());
            throw new JspException(e.getMessage());
        }

        try {
            StringBuilder stringBuilder =
                    new StringBuilder("<nav class=\"mt-4\" aria-label=\"Page navigation example\">\n" +
                            "<ul class=\"pagination pagination-lg flex-wrap justify-content-center\">");


            String contextPath = pageContext.getServletContext().getContextPath();

            String currentTemplate =
                    "<li class=\"page-item\"><a class=\"page-link\" href=\"" + contextPath
                            + "/controller?command=" + command + "&page=%d\">%d</a></li>";

            for (int i = 1; i <= pageCount; i++) {
                stringBuilder.append(String.format(currentTemplate, i, i));
            }

            stringBuilder.append("</ul>\n" +
                    "            </nav>");
            pageContext.getOut().write(stringBuilder.toString());
        } catch (IOException e) {
            log.error("Error while writing to stream {}", e.getMessage());
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
