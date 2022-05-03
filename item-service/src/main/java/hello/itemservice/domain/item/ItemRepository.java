package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // spring 안에서는 원래 싱글톤이라 static 안써도 되긴함
    // 멀티쓰레드  환경에서는 HashMap X >> 여러개 동시 접근 막아야 함 >> ConcurrentHashMap
    private static final Map<Long,Item> store = new HashMap<>(); // static
    private static long sequence = 0L; // static

    public Item save(Item item){
        item.setId((++sequence));
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    // 프로젝트가 작아서 따로 dto 안만듬 (id 사용 X, setId X)
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // for test
    public void clearStore(){
        store.clear();
    }
}
