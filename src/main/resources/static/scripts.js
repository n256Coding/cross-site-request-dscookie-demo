$.post('/csrf', {}, function (data, status) {
    const csrf_token = data;
    $('<input>').attr({
        type: 'hidden',
        id: 'X-CSRFToken',
        name: 'csrf_token',
        value: data.csrf
    }).appendTo('form');
});

$('#my_data_form').submit(function (event) {
    event.preventDefault();
    var formData = {};
    formData.car_brand = $('#car_brand').val();
    formData.drink = $('#drink').val();
    formData.tv_show = $('#tv_show').val();
    formData.csrf_token = $('#X-CSRFToken').val();


    $.ajax({
        type : "POST",
        url : "/mydata",
        data : JSON.stringify(formData),
        contentType : 'application/json',
        success : function (data, status) {
            console.log("Inside post");
            if(status == "success") {
                if (data.response == "success") {
                    $("#form_response").html('Data has successfully recorded.');
                }
                else if (data.response == "invalid") {
                    $("#form_response").html('Request forbidden. Nothing recorded.');
                }
            }
            else{
                $("#form_response").html('Unknown error occurred. Try again');
            }
            $('#informationModel').modal('show');
        },
        dataType : "json"
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