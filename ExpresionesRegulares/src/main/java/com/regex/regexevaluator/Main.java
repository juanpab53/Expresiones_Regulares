package com.regex.regexevaluator;

import com.regex.regexevaluator.controller.RegexController;
import com.regex.regexevaluator.views.ClientView;

public class Main {
    public static void main(String[] args) {
        RegexController controller = new RegexController();
        ClientView view = new ClientView(controller);
        view.iniciar();
    }
}
