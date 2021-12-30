package tr.app.com.bean;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Faces;
import tr.app.com.entity.Kullanici;
import tr.app.com.service.KullaniciService;
import tr.app.com.session.Util;

@Named(value = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    @EJB
    private KullaniciService kullaniciService;
    @Getter
    @Setter
    private Integer sicil;
    @Getter
    @Setter
    private String sifre;

    @Getter
    @Setter
    private Kullanici kullanici;

    public LoginBean() {
    }

    public String girisKontrol() {
        try {
            kullanici = kullaniciService.girisKontrol(sicil, sifre);

            if (kullanici == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hata : ", "Lütfen Kullanıcı Bilgilerini Kontrol ediniz."));

            } else {
                //Kullanıcı Bilgilerini Sessiona At..
                HttpSession session = Util.getSession();
                session.setAttribute("kullanici", kullanici);
                return "index.xhtml?faces-redirect=true";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void cikisYap() {
        try {
            HttpSession session = Util.getSession();
            kullanici = Util.getKullanici();
            session.setAttribute("kullanici", null);
            Faces.getExternalContext().getFlash().setKeepMessages(true);
            session.invalidate();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Başarılı : ", "Başarıyla çıkış yaptınız."));

            // HttpSession session = Util.getSession(); : session oluşturulur.
            // session.setAttribute("kullanici", kullanici); : Sessiona kullanıcı bilgileri atılır.
            if(Util.getSession() == null){
               Faces.redirect("login.xhtml"); 
            }else{
                Faces.redirect("index.xhtml");
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
