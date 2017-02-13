package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserRepositoryRealmProxy extends com.example.app.testapp.data.entity.UserRepository
    implements RealmObjectProxy, UserRepositoryRealmProxyInterface {

    static final class UserRepositoryColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long languageIndex;
        public long repositoryTitleIndex;
        public long forksIndex;
        public long starsIndex;

        UserRepositoryColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.idIndex = getValidColumnIndex(path, table, "UserRepository", "id");
            indicesMap.put("id", this.idIndex);
            this.languageIndex = getValidColumnIndex(path, table, "UserRepository", "language");
            indicesMap.put("language", this.languageIndex);
            this.repositoryTitleIndex = getValidColumnIndex(path, table, "UserRepository", "repositoryTitle");
            indicesMap.put("repositoryTitle", this.repositoryTitleIndex);
            this.forksIndex = getValidColumnIndex(path, table, "UserRepository", "forks");
            indicesMap.put("forks", this.forksIndex);
            this.starsIndex = getValidColumnIndex(path, table, "UserRepository", "stars");
            indicesMap.put("stars", this.starsIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final UserRepositoryColumnInfo otherInfo = (UserRepositoryColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.languageIndex = otherInfo.languageIndex;
            this.repositoryTitleIndex = otherInfo.repositoryTitleIndex;
            this.forksIndex = otherInfo.forksIndex;
            this.starsIndex = otherInfo.starsIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final UserRepositoryColumnInfo clone() {
            return (UserRepositoryColumnInfo) super.clone();
        }

    }
    private UserRepositoryColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("language");
        fieldNames.add("repositoryTitle");
        fieldNames.add("forks");
        fieldNames.add("stars");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    UserRepositoryRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserRepositoryColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.app.testapp.data.entity.UserRepository.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$language() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.languageIndex);
    }

    public void realmSet$language(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.languageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.languageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.languageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.languageIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$repositoryTitle() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.repositoryTitleIndex);
    }

    public void realmSet$repositoryTitle(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.repositoryTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.repositoryTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.repositoryTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.repositoryTitleIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$forks() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.forksIndex);
    }

    public void realmSet$forks(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.forksIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.forksIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$stars() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.starsIndex);
    }

    public void realmSet$stars(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.starsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.starsIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("UserRepository")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("UserRepository");
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("language", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("repositoryTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("forks", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("stars", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("UserRepository");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_UserRepository")) {
            Table table = sharedRealm.getTable("class_UserRepository");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "language", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "repositoryTitle", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "forks", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "stars", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_UserRepository");
    }

    public static UserRepositoryColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_UserRepository")) {
            Table table = sharedRealm.getTable("class_UserRepository");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final UserRepositoryColumnInfo columnInfo = new UserRepositoryColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("language")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'language' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("language") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'language' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.languageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'language' is required. Either set @Required to field 'language' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("repositoryTitle")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'repositoryTitle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("repositoryTitle") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'repositoryTitle' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.repositoryTitleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'repositoryTitle' is required. Either set @Required to field 'repositoryTitle' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("forks")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'forks' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("forks") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'forks' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.forksIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'forks' does support null values in the existing Realm file. Use corresponding boxed type for field 'forks' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("stars")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stars' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("stars") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'stars' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.starsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'stars' does support null values in the existing Realm file. Use corresponding boxed type for field 'stars' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'UserRepository' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_UserRepository";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.app.testapp.data.entity.UserRepository createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.app.testapp.data.entity.UserRepository obj = null;
        if (update) {
            Table table = realm.getTable(com.example.app.testapp.data.entity.UserRepository.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.app.testapp.data.entity.UserRepository.class), false, Collections.<String> emptyList());
                    obj = new io.realm.UserRepositoryRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.UserRepositoryRealmProxy) realm.createObjectInternal(com.example.app.testapp.data.entity.UserRepository.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.UserRepositoryRealmProxy) realm.createObjectInternal(com.example.app.testapp.data.entity.UserRepository.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("language")) {
            if (json.isNull("language")) {
                ((UserRepositoryRealmProxyInterface) obj).realmSet$language(null);
            } else {
                ((UserRepositoryRealmProxyInterface) obj).realmSet$language((String) json.getString("language"));
            }
        }
        if (json.has("repositoryTitle")) {
            if (json.isNull("repositoryTitle")) {
                ((UserRepositoryRealmProxyInterface) obj).realmSet$repositoryTitle(null);
            } else {
                ((UserRepositoryRealmProxyInterface) obj).realmSet$repositoryTitle((String) json.getString("repositoryTitle"));
            }
        }
        if (json.has("forks")) {
            if (json.isNull("forks")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'forks' to null.");
            } else {
                ((UserRepositoryRealmProxyInterface) obj).realmSet$forks((int) json.getInt("forks"));
            }
        }
        if (json.has("stars")) {
            if (json.isNull("stars")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'stars' to null.");
            } else {
                ((UserRepositoryRealmProxyInterface) obj).realmSet$stars((int) json.getInt("stars"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.app.testapp.data.entity.UserRepository createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.app.testapp.data.entity.UserRepository obj = new com.example.app.testapp.data.entity.UserRepository();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((UserRepositoryRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("language")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRepositoryRealmProxyInterface) obj).realmSet$language(null);
                } else {
                    ((UserRepositoryRealmProxyInterface) obj).realmSet$language((String) reader.nextString());
                }
            } else if (name.equals("repositoryTitle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRepositoryRealmProxyInterface) obj).realmSet$repositoryTitle(null);
                } else {
                    ((UserRepositoryRealmProxyInterface) obj).realmSet$repositoryTitle((String) reader.nextString());
                }
            } else if (name.equals("forks")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'forks' to null.");
                } else {
                    ((UserRepositoryRealmProxyInterface) obj).realmSet$forks((int) reader.nextInt());
                }
            } else if (name.equals("stars")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'stars' to null.");
                } else {
                    ((UserRepositoryRealmProxyInterface) obj).realmSet$stars((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.app.testapp.data.entity.UserRepository copyOrUpdate(Realm realm, com.example.app.testapp.data.entity.UserRepository object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.app.testapp.data.entity.UserRepository) cachedRealmObject;
        } else {
            com.example.app.testapp.data.entity.UserRepository realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.app.testapp.data.entity.UserRepository.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((UserRepositoryRealmProxyInterface) object).realmGet$id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.app.testapp.data.entity.UserRepository.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.UserRepositoryRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.example.app.testapp.data.entity.UserRepository copy(Realm realm, com.example.app.testapp.data.entity.UserRepository newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.app.testapp.data.entity.UserRepository) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.app.testapp.data.entity.UserRepository realmObject = realm.createObjectInternal(com.example.app.testapp.data.entity.UserRepository.class, ((UserRepositoryRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((UserRepositoryRealmProxyInterface) realmObject).realmSet$language(((UserRepositoryRealmProxyInterface) newObject).realmGet$language());
            ((UserRepositoryRealmProxyInterface) realmObject).realmSet$repositoryTitle(((UserRepositoryRealmProxyInterface) newObject).realmGet$repositoryTitle());
            ((UserRepositoryRealmProxyInterface) realmObject).realmSet$forks(((UserRepositoryRealmProxyInterface) newObject).realmGet$forks());
            ((UserRepositoryRealmProxyInterface) realmObject).realmSet$stars(((UserRepositoryRealmProxyInterface) newObject).realmGet$stars());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.app.testapp.data.entity.UserRepository object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.app.testapp.data.entity.UserRepository.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserRepositoryColumnInfo columnInfo = (UserRepositoryColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.UserRepository.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((UserRepositoryRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRepositoryRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((UserRepositoryRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$language = ((UserRepositoryRealmProxyInterface)object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
        }
        String realmGet$repositoryTitle = ((UserRepositoryRealmProxyInterface)object).realmGet$repositoryTitle();
        if (realmGet$repositoryTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.repositoryTitleIndex, rowIndex, realmGet$repositoryTitle, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.forksIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$forks(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.starsIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$stars(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.app.testapp.data.entity.UserRepository.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserRepositoryColumnInfo columnInfo = (UserRepositoryColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.UserRepository.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.app.testapp.data.entity.UserRepository object = null;
        while (objects.hasNext()) {
            object = (com.example.app.testapp.data.entity.UserRepository) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((UserRepositoryRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRepositoryRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((UserRepositoryRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$language = ((UserRepositoryRealmProxyInterface)object).realmGet$language();
                if (realmGet$language != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
                }
                String realmGet$repositoryTitle = ((UserRepositoryRealmProxyInterface)object).realmGet$repositoryTitle();
                if (realmGet$repositoryTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.repositoryTitleIndex, rowIndex, realmGet$repositoryTitle, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.forksIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$forks(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.starsIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$stars(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.app.testapp.data.entity.UserRepository object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.app.testapp.data.entity.UserRepository.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserRepositoryColumnInfo columnInfo = (UserRepositoryColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.UserRepository.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((UserRepositoryRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRepositoryRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((UserRepositoryRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$language = ((UserRepositoryRealmProxyInterface)object).realmGet$language();
        if (realmGet$language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.languageIndex, rowIndex, false);
        }
        String realmGet$repositoryTitle = ((UserRepositoryRealmProxyInterface)object).realmGet$repositoryTitle();
        if (realmGet$repositoryTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.repositoryTitleIndex, rowIndex, realmGet$repositoryTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.repositoryTitleIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.forksIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$forks(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.starsIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$stars(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.app.testapp.data.entity.UserRepository.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserRepositoryColumnInfo columnInfo = (UserRepositoryColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.UserRepository.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.app.testapp.data.entity.UserRepository object = null;
        while (objects.hasNext()) {
            object = (com.example.app.testapp.data.entity.UserRepository) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((UserRepositoryRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRepositoryRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((UserRepositoryRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$language = ((UserRepositoryRealmProxyInterface)object).realmGet$language();
                if (realmGet$language != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.languageIndex, rowIndex, realmGet$language, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.languageIndex, rowIndex, false);
                }
                String realmGet$repositoryTitle = ((UserRepositoryRealmProxyInterface)object).realmGet$repositoryTitle();
                if (realmGet$repositoryTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.repositoryTitleIndex, rowIndex, realmGet$repositoryTitle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.repositoryTitleIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.forksIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$forks(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.starsIndex, rowIndex, ((UserRepositoryRealmProxyInterface)object).realmGet$stars(), false);
            }
        }
    }

    public static com.example.app.testapp.data.entity.UserRepository createDetachedCopy(com.example.app.testapp.data.entity.UserRepository realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.app.testapp.data.entity.UserRepository unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.app.testapp.data.entity.UserRepository)cachedObject.object;
            } else {
                unmanagedObject = (com.example.app.testapp.data.entity.UserRepository)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.app.testapp.data.entity.UserRepository();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((UserRepositoryRealmProxyInterface) unmanagedObject).realmSet$id(((UserRepositoryRealmProxyInterface) realmObject).realmGet$id());
        ((UserRepositoryRealmProxyInterface) unmanagedObject).realmSet$language(((UserRepositoryRealmProxyInterface) realmObject).realmGet$language());
        ((UserRepositoryRealmProxyInterface) unmanagedObject).realmSet$repositoryTitle(((UserRepositoryRealmProxyInterface) realmObject).realmGet$repositoryTitle());
        ((UserRepositoryRealmProxyInterface) unmanagedObject).realmSet$forks(((UserRepositoryRealmProxyInterface) realmObject).realmGet$forks());
        ((UserRepositoryRealmProxyInterface) unmanagedObject).realmSet$stars(((UserRepositoryRealmProxyInterface) realmObject).realmGet$stars());
        return unmanagedObject;
    }

    static com.example.app.testapp.data.entity.UserRepository update(Realm realm, com.example.app.testapp.data.entity.UserRepository realmObject, com.example.app.testapp.data.entity.UserRepository newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((UserRepositoryRealmProxyInterface) realmObject).realmSet$language(((UserRepositoryRealmProxyInterface) newObject).realmGet$language());
        ((UserRepositoryRealmProxyInterface) realmObject).realmSet$repositoryTitle(((UserRepositoryRealmProxyInterface) newObject).realmGet$repositoryTitle());
        ((UserRepositoryRealmProxyInterface) realmObject).realmSet$forks(((UserRepositoryRealmProxyInterface) newObject).realmGet$forks());
        ((UserRepositoryRealmProxyInterface) realmObject).realmSet$stars(((UserRepositoryRealmProxyInterface) newObject).realmGet$stars());
        return realmObject;
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRepositoryRealmProxy aUserRepository = (UserRepositoryRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUserRepository.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUserRepository.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUserRepository.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
