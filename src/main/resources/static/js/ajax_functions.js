$("#login-form").submit(function (event) {

        //stop submit the form event. Do this manually using ajax post function
                event.preventDefault();

                var loginForm = {}
                loginForm["countryName"] = $("#countryName").val();
                loginForm["leagueName"] = $("#leagueName").val();
                loginForm["teamName"] = $("#teamName").val();

      $("#btn-login").prop("disabled", true);

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/v1/standings",
            data: jQuery.param({ countryName: loginForm["countryName"], leagueName : loginForm["leagueName"], teamName: loginForm["teamName"]}) ,
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success : function(response) {
                //TODO Write response
                var json = "<h4>Response</h4><pre>"
                                    + JSON.stringify(response, null, 4) + "</pre>";
                                $('#feedback').html(json);

                                console.log("SUCCESS : ", data);
                                $("#btn-login").prop("disabled", false);


                        },
                        error : function() {
                            var json = "<h4>No Data Found</h4>";
                             $('#feedback').html(json);
                        }
        });
});