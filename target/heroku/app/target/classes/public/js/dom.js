document.addEventListener("DOMContentLoaded",function(){

    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, options);

    console.log("DOMContentLoaded done loading up");

    window.addEventListener("load",function(){
        console.log("Inside window loading event listener");
    });

    $(document).ready(function(){
        $('select').formSelect();
    });
});

