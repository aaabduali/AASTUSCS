$(document).ready( function () {
$('#example2').DataTable({
    "ajax":[
        {"url":"/users/table"},
        {"dataSrc":"data"}
    ],

    "columns":[
        {"data":"firstName"},
        {"data":"lastName"},
        {"data":"username"},
        {"data":"respSector.name"},
        {"data":"phone"}
    ]
});
});