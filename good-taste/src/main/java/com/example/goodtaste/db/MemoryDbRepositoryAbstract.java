package com.example.goodtaste.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {

        var item = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();
        if (item.isEmpty()) {
            index++;
            entity.setIndex(index);
        } else {
            var preIndex = item.get().getIndex();
            deleteById(preIndex);
            entity.setIndex(preIndex);
        }
        db.add(entity);
        return entity;
    }

    @Override
    public void deleteById(int index) {
        var item = db.stream().filter(it -> it.getIndex() == index).findFirst();
        item.ifPresent(db::remove);
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
