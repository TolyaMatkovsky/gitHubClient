package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.example.app.testapp.data.entity.User.class);
        modelClasses.add(com.example.app.testapp.data.entity.UserRepository.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return io.realm.UserRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return io.realm.UserRepositoryRealmProxy.initTable(sharedRealm);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return io.realm.UserRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return io.realm.UserRepositoryRealmProxy.createRealmObjectSchema(realmSchema);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return io.realm.UserRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return io.realm.UserRepositoryRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return io.realm.UserRealmProxy.getFieldNames();
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return io.realm.UserRepositoryRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return io.realm.UserRealmProxy.getTableName();
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return io.realm.UserRepositoryRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
                return clazz.cast(new io.realm.UserRealmProxy());
            } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
                return clazz.cast(new io.realm.UserRepositoryRealmProxy());
            } else {
                throw getMissingProxyClassException(clazz);
            }
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.copyOrUpdate(realm, (com.example.app.testapp.data.entity.User) obj, update, cache));
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return clazz.cast(io.realm.UserRepositoryRealmProxy.copyOrUpdate(realm, (com.example.app.testapp.data.entity.UserRepository) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            io.realm.UserRealmProxy.insert(realm, (com.example.app.testapp.data.entity.User) object, cache);
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            io.realm.UserRepositoryRealmProxy.insert(realm, (com.example.app.testapp.data.entity.UserRepository) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
                io.realm.UserRealmProxy.insert(realm, (com.example.app.testapp.data.entity.User) object, cache);
            } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
                io.realm.UserRepositoryRealmProxy.insert(realm, (com.example.app.testapp.data.entity.UserRepository) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
                    io.realm.UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
                    io.realm.UserRepositoryRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            io.realm.UserRealmProxy.insertOrUpdate(realm, (com.example.app.testapp.data.entity.User) obj, cache);
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            io.realm.UserRepositoryRealmProxy.insertOrUpdate(realm, (com.example.app.testapp.data.entity.UserRepository) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
                io.realm.UserRealmProxy.insertOrUpdate(realm, (com.example.app.testapp.data.entity.User) object, cache);
            } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
                io.realm.UserRepositoryRealmProxy.insertOrUpdate(realm, (com.example.app.testapp.data.entity.UserRepository) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
                    io.realm.UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
                    io.realm.UserRepositoryRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return clazz.cast(io.realm.UserRepositoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return clazz.cast(io.realm.UserRepositoryRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.example.app.testapp.data.entity.User.class)) {
            return clazz.cast(io.realm.UserRealmProxy.createDetachedCopy((com.example.app.testapp.data.entity.User) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.example.app.testapp.data.entity.UserRepository.class)) {
            return clazz.cast(io.realm.UserRepositoryRealmProxy.createDetachedCopy((com.example.app.testapp.data.entity.UserRepository) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
