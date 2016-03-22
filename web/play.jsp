<%@ page import="com.mygame.samples.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game</title>
</head>
<body>
<%  response.setIntHeader("Refresh", 4);%>
<%  String userName;
    List<Economical> EconomicalbuildingsList = new LinkedList<Economical>();
    final int[] underBuiling = {0};
    session = request.getSession();
    Warehouse warehouse = new Warehouse();
    SettlersList settlersList = new SettlersList();
    Barrack barrack;
    Timer timer = new Timer();


    if (request.getParameter("begin") != null) {
        warehouse = new Warehouse(20, 10, 10);
        barrack = new Barrack(settlersList);
        userName = request.getParameter("userName");
        session.setAttribute("savedUserName", userName);
    }
    else {
        warehouse = (Warehouse) session.getAttribute("warehouse");
        barrack = (Barrack) session.getAttribute("barrack") ;
        settlersList = (SettlersList) session.getAttribute("settlersList");
        EconomicalbuildingsList = (LinkedList<Economical>) session.getAttribute("buildingList");
        timer = (Timer) session.getAttribute("timer");
        underBuiling[0] = (int) session.getAttribute("underBuilt");
    }
    String textBox = ("Welcome Lord " + session.getAttribute("savedUserName"));

%>

<%
    for (int i = 0; i<EconomicalbuildingsList.size(); i++){
        if(request.getParameter("stopProduction" + i) != null)
            EconomicalbuildingsList.get(i).changeProduction();
        if (request.getParameter("underCollecting" + i) != null)
            EconomicalbuildingsList.get(i).underCollecting();
    }


    if (request.getParameter("sawmill") != null && warehouse.getWood() >= 3 && warehouse.getStone() >= 1 && settlersList.getBuilders()> underBuiling[0] && settlersList.getFreeones()>= 1){
        warehouse.useStone(1);
        warehouse.useWood(3);
        underBuiling[0]++;
        EconomicalbuildingsList.add(new Sawmill(settlersList));
        textBox = "Sawmill is added to built";
    }
    else if (request.getParameter("sawmill") != null && settlersList.getBuilders() ==  underBuiling[0])
        textBox = "There is no free builder in the village";
    else if (request.getParameter("sawmill") != null && warehouse.getStone() < 1 && warehouse.getWood() < 3)
        textBox = "There are no enought materials in warehouse";
    else if (request.getParameter("sawmill") != null && warehouse.getStone() < 1)
        textBox = "There is no enought stone in warehouse";
    else if (request.getParameter("sawmill") != null && warehouse.getWood() < 3)
        textBox = "There is no enought wood in warehouse";
    else if (request.getParameter("sawmill") != null && settlersList.getFreeones()== 0)
        textBox = "There is no free man in the village";

    if (request.getParameter("stonecutter") != null && warehouse.getWood() >= 3 && warehouse.getStone() >= 2 && settlersList.getBuilders()> underBuiling[0] && settlersList.getFreeones()>= 1){
        warehouse.useStone(2);
        warehouse.useWood(3);
        underBuiling[0]++;
        EconomicalbuildingsList.add(new StoneCutter(settlersList));
        textBox = "Stone cutter is added to built";
    }
    else if (request.getParameter("stonecutter") != null && settlersList.getBuilders() ==  underBuiling[0])
        textBox = "There is no free builder in the village";
    else if (request.getParameter("stonecutter") != null && warehouse.getStone() < 2 && warehouse.getWood() < 3)
        textBox = "There are no enought materials in warehouse";
    else if (request.getParameter("stonecutter") != null && warehouse.getStone() < 2)
        textBox = "There is no enought stone in warehouse";
    else if (request.getParameter("stonecutter") != null && warehouse.getWood() < 3)
        textBox = "There is no enought wood in warehouse";
    else if (request.getParameter("stonecutter") != null && settlersList.getFreeones()== 0)
        textBox = "There is no free man in the village";

    if (request.getParameter("farm") != null && warehouse.getWood() >= 3 && warehouse.getStone() >= 3 && settlersList.getBuilders()> underBuiling[0] && settlersList.getFreeones()>= 1){
        warehouse.useStone(3);
        warehouse.useWood(3);
        underBuiling[0]++;
        EconomicalbuildingsList.add(new Farm(settlersList));
        textBox = "Farm is added to built";
    }

    else if (request.getParameter("farm") != null && settlersList.getBuilders() ==  underBuiling[0])
        textBox = "There is no free builder in the village";
    else if (request.getParameter("farm") != null && warehouse.getStone() < 3 && warehouse.getWood() < 3)
        textBox = "There are no enought materials in warehouse";
    else if (request.getParameter("farm") != null && warehouse.getStone() < 3)
        textBox = "There is no enought stone in warehouse";
    else if (request.getParameter("farm") != null && warehouse.getWood() < 3)
        textBox = "There is no enought wood in warehouse";
    else if (request.getParameter("farm") != null && settlersList.getFreeones()== 0)
        textBox = "There is no free man in the village";

    if (request.getParameter("hireBuilder") != null && settlersList.getFreeones()>= 1){
        settlersList.hireBuilder();
        textBox = "A new buider is waiting for your order";
    }
    else if (request.getParameter("hireBuilder") != null && settlersList.getFreeones() == 0)
        textBox = "There is no free man in the village";
    if (request.getParameter("hirePorter") != null && settlersList.getFreeones()>= 1){
        settlersList.hirePoreter();
        textBox = "A new porter is ready to work";
    }
    else if (request.getParameter("hirePorter") != null && settlersList.getFreeones()== 0)
        textBox = "There is no free man in the village";
%>


<h2><% out.print(textBox); %> </h2>


Building<br><br>

<% for (int i = 0; i<EconomicalbuildingsList.size(); i++) {
out.print(EconomicalbuildingsList.get(i).getAllInfo());
%>
<form method="post" action="play.jsp">
    <input value="run/stop production" name="<%out.print("stopProduction" + i);%>" type="submit">
    </input>
</form>
<form method="post" action="play.jsp">
    <input value="run/stop collecting" name="<%out.print("underCollecting" + i);%>" type="submit">
    </input>
</form>
<%
 } %>

<% out.print(warehouse.getAllInfo());%> <br><br>
<% out.print(barrack.getAllInfo());%> <br><br>
<% out.print(settlersList.getAllInfo());%> <br><br>

<form method="post"  action="/play.jsp">
    <input type ="radio" name="hirePorter" >porter</input>
    <input value="hire" type="submit"/>
    </form>
<form method="post"  action="/play.jsp">
    <input type ="radio" name="hireBuilder" >builder</input>
    <input value="hire" type="submit"/>
    </form>
<h4> Build</h4>
<form method="post"  action="/play.jsp">
    <input type ="radio" name="sawmill" > sawmill </input>
    <input value="build" type="submit"/>
    </form>

<form method="post"  action="/play.jsp">
    <input type ="radio" name="stonecutter" > stone cutter </input>
    <input value="build" type="submit"/>
    </form>
<form method="post"  action="/play.jsp">
    <input type ="radio" name="farm" > farm </input>
    <input value="build" type="submit"/>
    </form>


<%
    final Warehouse finalWarehouse = warehouse;
    final SettlersList finalSettlersList = settlersList;
    final List<Economical> finalEconomicalbuildingsList = EconomicalbuildingsList;
    underBuiling[0] = 0;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            finalWarehouse.useCorn(finalSettlersList.getComsunedCorn());
            for (Economical element : finalEconomicalbuildingsList) {
                element.product();
                if( element.returnWorkHours()== 0)
                    ++underBuiling[0];
                for(Settler settler : finalSettlersList.Porter)
                    settler.portering(element, finalWarehouse);
            }
            for(Settler settler : finalSettlersList.Porter)
                settler.setFree();
        }
    };

    EconomicalbuildingsList = finalEconomicalbuildingsList;
    warehouse = finalWarehouse;
    timer.schedule(task, 2000);
    session.setAttribute("timer", timer);
    session.setAttribute("buildingList", EconomicalbuildingsList);
    session.setAttribute("warehouse", warehouse);
    session.setAttribute("barrack", barrack);
    session.setAttribute("settlersList", settlersList);
    session.setAttribute("underBuilt", underBuiling[0]);
    out.close();
%>


</body>
</html>
