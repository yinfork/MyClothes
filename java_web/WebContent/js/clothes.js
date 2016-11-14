$(document).ready(function(){
    $(window).load(function () {
        imgLocation();
    });


});


function imgLocation(){
    var box = $(".img_box");
    var boxWidth = box.eq(0).width();
    var num = Math.floor($(".wardrobe").width()/boxWidth);
    var boxArr=[];
    box.each(function(index,value){
//        console.log(index+"--"+value);
        var boxHeight = box.eq(index).height();
        if(index<num){
            boxArr[index]= boxHeight;
            console.log(boxHeight);
        }else{
            var minboxHeight = Math.min.apply(null,boxArr);
            console.log(minboxHeight);
            var minboxIndex = $.inArray(minboxHeight,boxArr);
            //console.log(minboxIndex);
//            console.log(value);
            $(value).css({
                "position":"absolute",
                "top":minboxHeight,
                "left":box.eq(minboxIndex).position().left
            });
            boxArr[minboxIndex]+=box.eq(index).height();
        }
    });
}