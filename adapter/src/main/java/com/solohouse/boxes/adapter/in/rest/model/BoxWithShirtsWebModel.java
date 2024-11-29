package com.solohouse.boxes.adapter.in.rest.model;

import java.util.List;

public record BoxWithShirtsWebModel(String name, BoxLocationWebModel location, List<BoxShirtWebModel> availableShirts) {
}
