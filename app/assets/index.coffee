$ ->
  $.get "/lunchOrders", (data) ->
    $.each data, (index, order) ->
        id = "order" + index
        elem = "<tr id=" + id + ">"
        $("#orders").append $(elem)
        $("#" + id).append $("<td>").text order.assignee
        $("#" + id).append $("<td>").text order.contents
        $("#" + id).append $("<td>").text order.date
