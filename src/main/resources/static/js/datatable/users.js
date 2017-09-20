$(document).ready( function () {
    var table = $('#example2').DataTable({
        "sAjaxSource": "/users/table",
        "sPaginationType" : 'simple_numbers',
        "sAjaxDataProp": "",
        "order": [[ 0, "dsc" ]],



        "aoColumns": [
            { "mData": "phone" },
            { "mRender": function (data, type, row) {


            }}
        ],
    });

    $(table).on( 'click', 'tbody tr', function () {
        window.location.href = $(this).attr('href');
    } );

});
