package fr.sewatech.formation.jsf;

import javax.el.ELResolver;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LoginPhaseListener implements PhaseListener {

	public void beforePhase(PhaseEvent event) {
	}

	public void afterPhase(PhaseEvent event) {
		System.out.println("afterPhase : " + event.getPhaseId());
		FacesContext context = event.getFacesContext();
		ELResolver resolver = context.getApplication().getELResolver();
		LoginBean loginBean = (LoginBean)resolver.getValue(context.getELContext(), null, "loginBean");

		String viewId = event.getFacesContext().getViewRoot().getViewId();
		if (!loginBean.isValid() && !"/login.xhtml".equals(viewId)) {
			System.out.println("viewId : " + viewId);
			NavigationHandler navigation = context.getApplication().getNavigationHandler();
			navigation.handleNavigation(context, null, "login?faces-redirect=true");
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
