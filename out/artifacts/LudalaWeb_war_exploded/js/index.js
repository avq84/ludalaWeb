var tabs = {
    controllerURL: "getFeed",
    news: {
        id: "news",
        url: "http://news.yahoo.com/rss/sports",
        containerId:"newsFeedContainer",
        isLoaded:true
    },
    entretainment: {
        id: "entretainment",
        url: "http://news.yahoo.com/rss/entertainment",
        containerId:"entretainmentFeedContainer",
        isLoaded:false
    },
    techNews: {
        id: "techNews",
        url: "http://news.yahoo.com/rss/tech",
        containerId:"techNewsFeedContainer",
        isLoaded:false
    }
};

$.ajaxSetup({
    beforeSend:function(){
        // show gif here, eg:
        $("#loading").dialog("open");
    },
    complete:function(){
        // hide gif here, eg:
        $("#loading").dialog("close");
    }
});

$(document).ready(function() {
    //$(window).resize(function() {
    //    alert("resize");
    //});

    $("#menuBtn").click(function(){
        if($("#tabs ul:first").css("display") == "none"){
            $("#tabs ul:first").css("display","block");
        }else{
            $("#tabs ul:first").css("display","none");
        }
    });

    if($("#menuBtn").css("display") != "none"){
        $("#tabs ul:first").css("display","none");
        $("#tabs ul:first li").click(function(){
            $("#menuBtn").click();
        });
    }

    $("#tabs").tabs();
    $("#loading").dialog({
        modal: true,
        position: { my: "center top", at: "center top", of: $("#tabs") }
    });

    getNews();

    $("#entretainmentTab").click(function(){
        if(!tabs.entretainment.isLoaded){
            getEntretainment();
            tabs.entretainment.isLoaded = true;
        }
    });

    $("#techNewsTab").click(function(){
        if(!tabs.techNews.isLoaded){
            getTechNews();
            tabs.techNews.isLoaded = true;
        }
    });

    $('#newsRefresh').click(function(){
        getNews();
    });

    $('#entretainmentRefresh').click(function(){
        getEntretainment();
    });

    $('#techNewsRefresh').click(function(){
        getTechNews();
    });

});



function ajaxCall(object){
    $.ajax({
        url:tabs.controllerURL,
        type:'GET',
        data:{
            targetUrl: object.url
        },
        dataType:"json",
        success:function(data){
            $("#"+object.containerId).empty();
            for(var index = 0; index < data.items.length; index++){
                var item = data.items[index];
                $("#"+object.containerId).append("<li class='itemContainer'>" +
                    "<a href='" + item.link +"'>" +
                    "<h4>"+item.title+"</h4></a>" +
                    item.description +
                    "</li><hr>"
                );
            }
        }
    });
}

function getNews(){
    ajaxCall(tabs.news);
}

function getEntretainment(){
    ajaxCall(tabs.entretainment);
}

function getTechNews(){
    ajaxCall(tabs.techNews);
}
