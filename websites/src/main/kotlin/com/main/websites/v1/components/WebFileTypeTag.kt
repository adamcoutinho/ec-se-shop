package com.main.websites.v1.components

import javax.servlet.jsp.tagext.BodyTagSupport

data class WebFileTypeTag(var fileType: String?=null) : BodyTagSupport() {

    override fun doEndTag(): Int {
        val stringBuffer = StringBuffer(bodyContent.string)
        val out = bodyContent.getEnclosingWriter();
        when (this.fileType) {
            "js" -> {
                out.println("<script>")
                out.println(stringBuffer)
                out.println("</script>")
            }
            "css" -> {
                out.println("<style>")
                out.println(stringBuffer)
                out.println("</style>")
            }
        }
        return EVAL_PAGE
    }
}