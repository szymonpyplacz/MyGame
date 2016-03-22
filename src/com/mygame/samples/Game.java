//package com.mygame.samples;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.*;
//
//
//
//@WebServlet(name = "GameServlet", urlPatterns = { "/game"})
//public class Game extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Economical> EconomicalbuildingsList = new LinkedList<Economical>();
//        HttpSession session = request.getSession();
//        Warehouse warehouse = new Warehouse();
//        SettlersList settlersList = new SettlersList();
//        Barrack barrack;
//        String userName;
//        Timer timer = new Timer();
//
//        if (request.getParameter("begin") != null) {
//            warehouse = new Warehouse(20, 10, 10);
//            barrack = new Barrack(settlersList);
//            userName = request.getParameter("userName");
//            session.setAttribute("savedUserName", userName);
//        }
//        else {
//            warehouse = (Warehouse) session.getAttribute("warehouse");
//            barrack = (Barrack) session.getAttribute("barrack") ;
//            settlersList = (SettlersList) session.getAttribute("settlersList");
//            EconomicalbuildingsList = (LinkedList<Economical>) session.getAttribute("buildingList");
//            timer = (Timer) session.getAttribute("timer");
//        }
//        if (request.getParameter("sawmill") != null && warehouse.getWood() >= 3 && warehouse.getStone() >= 1){
//            warehouse.useStone(1);
//            warehouse.useWood(3);
//            EconomicalbuildingsList.add(new Sawmill(settlersList));
//        }
//        if (request.getParameter("stonecutter") != null && warehouse.getWood() >= 3 && warehouse.getStone() >= 2){
//            warehouse.useStone(2);
//            warehouse.useWood(3);
//            EconomicalbuildingsList.add(new StoneCutter(settlersList));
//        }
//        if (request.getParameter("farm") != null && warehouse.getWood() >= 3 && warehouse.getStone() >= 3){
//            warehouse.useStone(3);
//            warehouse.useWood(3);
//            EconomicalbuildingsList.add(new Farm(settlersList));
//        }
//        if (request.getParameter("hireBuilder") != null && settlersList.getFreeones()>= 1){
//            settlersList.hireBuilder();
//        }
//        if (request.getParameter("hirePorter") != null && settlersList.getFreeones()>= 1){
//            settlersList.hirePoreter();
//        }
//
//
//        PrintWriter out = response.getWriter();
//        out.print("<p>Welcome "+  (String) session.getAttribute("savedUserName") + " </p>");
//        out.print(" <h4>Buildings: </h4>");
//
//        for (Economical element : EconomicalbuildingsList) {
//            out.print(element.getAllInfo());
//            if (request.getParameter("begin") == null) {
////                element.product();
//            }
//        }
//
//        out.print(warehouse.getAllInfo() + "<br><br>" + barrack.getAllInfo() + "<br><br>" + settlersList.getAllInfo() + "<br>"  +  "<h4>  Hire </h4>");
//
//        out.print(
//                "<form method=\"post\"  action=\"/game\">" +
//                        "<input type =\"radio\"/ name=\"hirePorter\" >porter</input>" +
//                        "<input value=\"hire\" type=\"submit\"/>"+
//                        "</form>");
//
//        out.print(
//                "<form method=\"post\"  action=\"/game\">" +
//                        "<input type =\"radio\"/ name=\"hireBuilder\" >builder</input>" +
//                        "<input value=\"hire\" type=\"submit\"/>"+
//                        "</form>");
//
//
//        out.print("<h4> Build</button></h4>" );
//        out.print(
//                "<form method=\"post\"  action=\"/game\">" +
//                "<input type =\"radio\"/ name=\"sawmill\" > sawmill </input>" +
//                "<input value=\"build\" type=\"submit\"/>"+
//                "</form>");
//
//        out.print(
//                        "<form method=\"post\"  action=\"/game\">" +
//                        "<input type =\"radio\"/ name=\"stonecutter\" > stone cutter </input>" +
//                        "<input value=\"build\" type=\"submit\"/>"+
//                        "</form>");
//        out.print(
//                "<form method=\"post\"  action=\"/game\">" +
//                        "<input type =\"radio\"/ name=\"farm\" > farm </input>" +
//                        "<input value=\"build\" type=\"submit\"/>"+
//                        "</form>");
//
//
//        out.flush();
//
//        final Warehouse finalWarehouse = warehouse;
//        final SettlersList finalSettlersList = settlersList;
//        final List<Economical> finalEconomicalbuildingsList = EconomicalbuildingsList;
//
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                    finalWarehouse.useCorn(finalSettlersList.getComsunedCorn());
//                for (Economical element : finalEconomicalbuildingsList) {
//                    element.product();
//                    for(Settler settler : finalSettlersList.Porter)
//                    settler.portering(element, finalWarehouse);
//                    }
//                }
//        };
//
//        EconomicalbuildingsList = finalEconomicalbuildingsList;
//        warehouse = finalWarehouse;
//        timer.schedule(task, 5000);
//        session.setAttribute("timer", timer);
//        session.setAttribute("buildingList", EconomicalbuildingsList);
//        session.setAttribute("warehouse", warehouse);
//        session.setAttribute("barrack", barrack);
//        session.setAttribute("settlersList", settlersList);
//        out.close();
//
//    }
//}
//
//
