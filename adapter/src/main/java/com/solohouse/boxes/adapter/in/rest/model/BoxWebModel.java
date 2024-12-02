package com.solohouse.boxes.adapter.in.rest.model;

import java.util.List;

public record BoxWebModel(Integer id, String name, BoxLocationWebModel location,
                          List<BoxShirtWebModel> availableShirts) {
}
