$ ->
  $.get "/lunchOrders", (data) ->
    $.each data, (index, lunchOrder) ->
        id = "order" + index
        elem = "<tr id=" + id + ">"
        $("#orders").append $(elem)
        $("#" + id).append $("<td>").text lunchOrder.name
        $("#" + id).append $("<td>").text lunchOrder.restaurant
        $("#" + id).append $("<td>").text lunchOrder.order
        $("#" + id).append $("<td>").text lunchOrder.specialRequest

