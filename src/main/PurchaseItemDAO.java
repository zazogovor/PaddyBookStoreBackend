package main;

import entity.PurchaseItem;
import persistence.PersistenceUtil;

public class PurchaseItemDAO {

    public static void createPurchaseItem(PurchaseItem pi){
        PersistenceUtil.persist(pi);
    }
}
