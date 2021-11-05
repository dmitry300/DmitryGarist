package by.training.barbershop.controller;

public class PagePath {
    public static final String REGISTRATION_PAGE = "/WEB-INF/page/registration.jsp";
    public static final String REGISTRATION_PAGE_REDIRECT = "/controller?command=go_to_registration";
    public static final String HOME_PAGE = "/WEB-INF/page/home.jsp";
    public static final String HOME_PAGE_REDIRECT = "/controller?command=home";
    public static final String LOGIN_PAGE = "/WEB-INF/page/login.jsp";
    public static final String LOGIN_PAGE_REDIRECT= "/controller?command=go_to_login";
    public static final String ABOUT_US_PAGE = "/WEB-INF/page/about_us.jsp";
    public static final String SERVICES_PAGE = "/WEB-INF/page/service.jsp";
    public static final String BARBERS_PAGE = "/WEB-INF/page/barber.jsp";
    public static final String ORDER_PAGE = "/WEB-INF/page/client/order.jsp";
    public static final String ORDER_PAGE_REDIRECT = "/controller?command=order";
    public static final String ORDER_WAITING = "/WEB-INF/page/client/order_waiting.jsp";
    public static final String ORDER_WAITING_REDIRECT = "/controller?command=go_to_order_waiting";
    public static final String CLIENT_PROFILE = "/WEB-INF/page/profile.jsp";
    public static final String CLIENT_PERSONAL_DATA = "/WEB-INF/page/client/client_personal_data.jsp";
    public static final String CLIENT_PERSONAL_DATA_REDIRECT = "/controller?command=client_personal_data";
    public static final String CLIENT_EDIT_PERSONAL_DATA = "/WEB-INF/page/client/client_edit_personal_data.jsp";
    public static final String ERROR_PAGE = "/WEB-INF/page/error.jsp";
    public static final String ERROR_404_PAGE = "/WEB-INF/page/error404.jsp";
    public static final String ERROR_500_PAGE = "/WEB-INF/page/error500.jsp";
    public static final String CLIENT_ORDERS = "/WEB-INF/page/client/client_orders.jsp";
    public static final String CLIENT_ORDERS_REDIRECT = "/controller?command=client_orders&page=1";
    public static final String CLIENT_ORDERS_MANAGE = "/WEB-INF/page/admin/client_orders_manage.jsp";
    public static final String CLIENT_ORDERS_MANAGE_REDIRECT = "/controller?command=view_orders&userId=";
    public static final String CLIENT_LIST_PAGE = "/WEB-INF/page/admin/clients_list.jsp";
    public static final String CLIENT_LIST_PAGE_REDIRECT = "/controller?command=clients_list&page=1";
    public static final String EDIT_ORDER_PAGE = "/WEB-INF/page/admin/edit_order.jsp";
    public static final String EDIT_ORDER_PAGE_REDIRECT = "/controller?command=go_to_edit_order&orderId=";
    public static final String ACTIVE_ORDERS_PAGE = "/WEB-INF/page/admin/active_orders.jsp";
    public static final String ACTIVE_ORDERS_PAGE_REDIRECT = "/controller?command=active_orders&page=1";
    public static final String LIST_HAIRCUTS_PAGE = "/WEB-INF/page/admin/list_haircuts.jsp";
    public static final String LIST_HAIRCUTS_PAGE_REDIRECT = "/controller?command=list_haircuts";
    public static final String EDIT_HAIRCUT_PAGE = "/WEB-INF/page/admin/edit_haircut.jsp";
    public static final String LIST_BARBERS_PAGE = "/WEB-INF/page/admin/list_barbers.jsp";
    public static final String LIST_BARBERS_PAGE_REDIRECT = "/controller?command=active_barbers";
    public static final String EDIT_BARBER_PAGE = "/WEB-INF/page/admin/edit_barber.jsp";
    public static final String REVIEW_BARBER_PAGE = "/WEB-INF/page/client/reviews.jsp";
    public static final String REVIEW_BARBER_PAGE_REDIRECT= "/controller?command=go_to_review&barberId=";
    public static final String EDIT_REVIEW_PAGE = "/WEB-INF/page/client/edit_review.jsp";
    public static final String LIST_BOOKED_TIME_PAGE = "/WEB-INF/page/client/list_booked_time.jsp";
}
