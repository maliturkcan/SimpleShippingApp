
package tr.app.com.session;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import tr.app.com.entity.Kullanici;

public class Util {
    

    public static HttpSession getSession() {

        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);

    }

    public static HttpServletRequest getRequest() {

        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();

    }

    public static Kullanici getKullanici() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        return (Kullanici) session.getAttribute("kullanici");

    }

}
