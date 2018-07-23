package com.MultiSafepay.classes;

public class RoundingPolicy {
	public modes mode = null;
	public rules rule = null;

	public enum modes {
		UP, DOWN, CEILING, HALF_UP, HALF_DOWN, FRIDAY, HALF_EVEN
	}

	public enum rules {
		PER_ITEM, PER_LINE, TOTAL
	}

	public static RoundingPolicy set(modes mode, rules rule) {
		RoundingPolicy policy = new RoundingPolicy();
		policy.mode = mode;
		policy.rule = rule;
		return policy;
	}
}