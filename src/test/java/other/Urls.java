package other;

import utils.PropertyManager;

public class Urls {
        public static final String LOGIN_PAGE = new PropertyManager().get("login.url");
        public static final String REGISTRATION_PAGE = new PropertyManager().get("registration.url");
        public static final String CHAT_PAGE = new PropertyManager().get("chat.url");
    }

