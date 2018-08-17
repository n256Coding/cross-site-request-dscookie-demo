$( document ).ready(function () {
    $('<input>').attr({
        type: 'hidden',
        id: 'X-CSRFToken',
        name: 'csrf_token',
        value: Cookies.get('csrf_token')
    }).appendTo('form');
});


$('#my_data_form').submit(function (event) {
    event.preventDefault();

    $.ajax({
        type : "POST",
        url : "/mydata",
        data :$(this).serialize(),
        success : function (data, status) {
            console.log("Inside post");
            if(status == "success") {
                if (data.response == "success") {
                    $("#form_response").html('Data has successfully recorded.');
                }
                else if (data.response == "invalid") {
                    $("#form_response").html('Request forbidden. Nothing transferred.');
                }
            }
            else{
                $("#form_response").html('Unknown error occurred. Try again');
            }
            $('#informationModel').modal('show');
        }
    });

    // $.post('/mydata', {
    //     'car_brand':$('#car_brand').val(),
    //     'drink' : $('#drink').val(),
    //     'tv_show' : $('#tv_show').val(),
    //     'csrf_token' : $('#X-CSRFToken').val()
    // }, function (data, status) {
    //     console.log("Inside post");
    //     if(status == "success") {
    //         if (data.response == "success") {
    //             $("#form_response").html('Data has successfully recorded.');
    //         }
    //         else if (data.response == "invalid") {
    //             $("#form_response").html('Request forbidden. Nothing recorded.');
    //         }
    //     }
    //     else{
    //         $("#form_response").html('Unknown error occurred. Try again');
    //     }
    //     $('#informationModel').modal('show');
    // });
});