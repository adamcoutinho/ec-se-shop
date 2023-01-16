package com.main.platform.workspace.websites.servlet.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

public class WebFileType extends BodyTagSupport {

    private String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    @Override
    public int doEndTag() throws JspException {
        try {

            String contentString = bodyContent.getString();
            StringBuffer stringBuffer = new StringBuffer(contentString);
            stringBuffer.reverse();
            JspWriter out = bodyContent.getEnclosingWriter();
            out.println("<script>");
            out.println(stringBuffer);
            out.println("</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
