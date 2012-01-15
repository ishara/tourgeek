/**
 * @(#)ItemPricingModel.
 * Copyright © 2011 tourapp.com. All rights reserved.
 */
package com.tourapp.model.tour.product.item.db;

import com.tourapp.model.tour.product.base.db.*;

public interface ItemPricingModel extends ProductPricingModel
{
    public static final String ITEM_PRICING_SCREEN_CLASS = "com.tourapp.tour.product.item.screen.ItemPricingScreen";
    public static final String ITEM_PRICING_GRID_SCREEN_CLASS = "com.tourapp.tour.product.item.screen.ItemPricingGridScreen";

    public static final String ITEM_PRICING_FILE = "ItemPricing";
    public static final String THIN_CLASS = "com.tourapp.thin.tour.product.item.db.ItemPricing";
    public static final String THICK_CLASS = "com.tourapp.tour.product.item.db.ItemPricing";

}
