/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.82
 * Generated at: 2023-12-07 10:34:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.gallery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.app.member.vo.MemberVo;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1701050848556L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1701926632846L));
    _jspx_dependants.put("jar:file:/C:/dev/wasRepo/webPrj99/src/main/webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.app.member.vo.MemberVo");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("	main{\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		height: 800px;\r\n");
      out.write("		display: grid;\r\n");
      out.write("		grid-template-rows: 1fr 7fr 2fr;\r\n");
      out.write("		grid-template-columns: 1fr;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#gallery-area{\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		height: 100%;\r\n");
      out.write("		display: grid;\r\n");
      out.write("		grid-template-rows: 1fr 1fr;\r\n");
      out.write("		grid-template-columns: 1fr 1fr 1fr;\r\n");
      out.write("		place-items: center center;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#gallery-box{\r\n");
      out.write("		display: flex;\r\n");
      out.write("		flex-direction: column;\r\n");
      out.write("		justify-content: center;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ galleryVoList }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("	<div id=\"wrap\">\r\n");
      out.write("		\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("        ");
 String x=(String) session.getAttribute("alertMsg"); session.removeAttribute("alertMsg"); MemberVo
            loginMember=(MemberVo)session.getAttribute("loginMember"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <script>\r\n");
      out.write("	");
 if (x != null) { 
      out.write("\r\n");
      out.write("                    alert(\"");
      out.print( x );
      out.write("\");\r\n");
      out.write("	");
 } 
      out.write("\r\n");
      out.write("            </script>\r\n");
      out.write("\r\n");
      out.write("            <link rel=\"stylesheet\" href=\"/app99/resources/css/header.css\">\r\n");
      out.write("\r\n");
      out.write("            <header>\r\n");
      out.write("                <div></div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <a href=\"/app99/home\">\r\n");
      out.write("                        <img width=\"300px\" height=\"120px\" src=\"/app99/resources/img/logo.png\" alt=\"로고이미지\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <form action=\"/app99/member/login\" method=\"post\">\r\n");
      out.write("                        <div class=\"login-area\">\r\n");
      out.write("                            ");
 if( loginMember==null ){ 
      out.write("\r\n");
      out.write("                                <input type=\"text\" name=\"memberId\" placeholder=\"아이디\">\r\n");
      out.write("                                <input type=\"password\" name=\"memberPwd\" placeholder=\"패스워드\">\r\n");
      out.write("                                <button type=\"button\" onclick=\"location.href='/app99/member/join';\">회원가입</button>\r\n");
      out.write("                                <input type=\"submit\" value=\"로그인\">\r\n");
      out.write("                                ");
 }else{ 
      out.write("\r\n");
      out.write("                                    <h3>\r\n");
      out.write("                                        ");
      out.print( loginMember.getMemberNick() );
      out.write("\r\n");
      out.write("                                    </h3>\r\n");
      out.write("                                    <br>\r\n");
      out.write("                                    님 환영합니다 :)\r\n");
      out.write("                                    <br>\r\n");
      out.write("                                    <button type=\"button\"\r\n");
      out.write("                                        onclick=\"location.href='/app99/member/logout'\">로그아웃</button>\r\n");
      out.write("                                    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <nav>\r\n");
      out.write("                        <a href=\"/app99/board/list?pno=1\">게시판</a>\r\n");
      out.write("                        <a href=\"/app99/notice/list\">공지사항</a>\r\n");
      out.write("                        <a href=\"/app99/gallery/list\">갤러리</a>\r\n");
      out.write("                        <a href=\"/app99/member/list\">마이페이지</a>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </header>");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<main>\r\n");
      out.write("			\r\n");
      out.write("			<div id=\"top-area\">\r\n");
      out.write("				<button onclick=\"location.href='/app99/gallery/write'\">작성하기</button>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div id=\"gallery-area\">\r\n");
      out.write("				");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div id=\"page-area\">\r\n");
      out.write("				<a href=\"\">1</a>\r\n");
      out.write("				<a href=\"\">2</a>\r\n");
      out.write("				<a href=\"\">3</a>\r\n");
      out.write("				<a href=\"\">4</a>\r\n");
      out.write("				<a href=\"\">5</a>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		</main>\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/gallery/list.jsp(54,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/gallery/list.jsp(54,4) '${ galleryVoList }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${ galleryVoList }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/gallery/list.jsp(54,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("vo");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("					<div id=\"gallery-box\">\r\n");
            out.write("						<img src=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ vo.src }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" alt=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ vo.originName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("						<span>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ vo.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span>\r\n");
            out.write("					</div>\r\n");
            out.write("				");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}