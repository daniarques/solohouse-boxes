package com.solohouse.boxes.adapter.in.rest.model;

import java.util.List;

public record BoxWithShirtsWebModel(Integer id, String name, BoxLocationWebModel location,
                                    List<BoxShirtWebModel> availableShirts) {
}
