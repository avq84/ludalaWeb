<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <link rel="stylesheet"  type="text/css" href="css/jquery-ui/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="css/ludalaWeb.css">
    <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <title></title>
</head>
<body>
    <img id="menuBtn" src="images/menuBtn48.png"/>
    <div id="tabs">
        <ul>
            <li id="newsTab"><a href="#newsContainer" class="tab">News</a></li>
            <li id="entretainmentTab"><a href="#entretainmentContainer" class="tab">Entretainement</a></li>
            <li id="techNewsTab"><a href="#techNewsContainer" class="tab">Tech News</a></li>
        </ul>
        <div id="newsContainer">
            <button id="newsRefresh">Refresh</button>
            <h3>News Feed</h3>
            <hr>
            <ul id="newsFeedContainer"></ul>
        </div>
        <div id="entretainmentContainer">
            <button id="entretainmentRefresh">Refresh</button>
            <h3>Entretainment Feed</h3>
            <hr>
            <ul id="entretainmentFeedContainer"></ul>
        </div>
        <div id="techNewsContainer">
            <button id="techNewsRefresh">Refresh</button>
            <h3>TechNews Feed</h3>
            <hr>
            <ul id="techNewsFeedContainer"></ul>
        </div>

    </div>
    <div id="loading">
        Loading...
    </div>
</body>
</html>