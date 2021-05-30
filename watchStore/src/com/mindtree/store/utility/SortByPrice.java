package com.mindtree.store.utility;

import java.util.Comparator;

import com.mindtree.store.entity.Watch;

public class SortByPrice implements Comparator<Watch> {

	@Override
	public int compare(Watch a, Watch b) {

		return (int) (a.getPrice() - b.getPrice());
	}

}
