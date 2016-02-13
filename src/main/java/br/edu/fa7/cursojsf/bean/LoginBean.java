package br.edu.fa7.cursojsf.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBean {

    private String username;
    private String password;


    public void login() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(true);
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        session.setAttribute("userLogged", username);

        context.redirect(request.getContextPath());
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
