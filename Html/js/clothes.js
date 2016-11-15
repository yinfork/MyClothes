$(document).ready(function () {
    $(window).load(function () {
        imgLocation();
    });


});


function imgLocation() {
    var box = $(".img_box");
    var boxWidth = box.eq(0).width();
    var num = Math.floor($(".wardrobe").width() / boxWidth);
    var boxArr = [];
    var maxHeight = 0;
    box.each(function (index, value) {
        var boxHeight = box.eq(index).height();
        if (index < num) {
            boxArr[index] = boxHeight;
            if (boxHeight > maxHeight) maxHeight = boxHeight;
        } else {
            var minboxHeight = Math.min.apply(null, boxArr);
            var minboxIndex = $.inArray(minboxHeight, boxArr);
            $(value).css({
                "position": "absolute",
                "top": minboxHeight,
                "left": box.eq(minboxIndex).position().left
            });
            boxArr[minboxIndex] += box.eq(index).height();
            if (boxArr[minboxIndex] > maxHeight) maxHeight = boxArr[minboxIndex];
        }
    });
    console.log("Max Height: " + maxHeight);
    $(".wardrobe").css({
        "border": "5px solid #000000",
        "height": maxHeight
    });
}