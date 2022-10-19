package com.maksgir.util;

import com.maksgir.entity.ResponseParams;

import java.util.List;

public class HtmlTableCreator {
    public static String createTableRows(List<ResponseParams> responseBeans) {
        StringBuilder result = new StringBuilder();
        for (ResponseParams params : responseBeans) {
            result.append(createTableRow(params));
        }
        return result.toString();
    }

    public static String createTableRow(ResponseParams params) {
        return "<tr>" +
                "<th class=\"result\">" + params.getX() + "</th>" +
                "<th class=\"result\">" + params.getY() + "</th>" +
                "<th class=\"result\">" + params.getR() + "</th>" +
                "<th class=\"result\">" + params.getStringDt() + "</th>" +
                "<th class=\"result\">" + params.getExecutionTime() + "</th>" +
                "<th class=\"result\">" + params.getAnswer() + "</th>" +
                "</tr>";

    }
}
