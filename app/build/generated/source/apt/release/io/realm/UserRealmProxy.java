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

public class UserRealmProxy extends com.example.app.testapp.data.entity.User
    implements RealmObjectProxy, UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long loginNameIndex;
        public long nameIndex;
        public long emailIndex;
        public long companyIndex;
        public long avatarURLIndex;
        public long htmlURLIndex;
        public long followersIndex;
        public long followingIndex;
        public long publicGistsIndex;
        public long publicReposIndex;
        public long repositoriesIndex;

        UserColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(12);
            this.idIndex = getValidColumnIndex(path, table, "User", "id");
            indicesMap.put("id", this.idIndex);
            this.loginNameIndex = getValidColumnIndex(path, table, "User", "loginName");
            indicesMap.put("loginName", this.loginNameIndex);
            this.nameIndex = getValidColumnIndex(path, table, "User", "name");
            indicesMap.put("name", this.nameIndex);
            this.emailIndex = getValidColumnIndex(path, table, "User", "email");
            indicesMap.put("email", this.emailIndex);
            this.companyIndex = getValidColumnIndex(path, table, "User", "company");
            indicesMap.put("company", this.companyIndex);
            this.avatarURLIndex = getValidColumnIndex(path, table, "User", "avatarURL");
            indicesMap.put("avatarURL", this.avatarURLIndex);
            this.htmlURLIndex = getValidColumnIndex(path, table, "User", "htmlURL");
            indicesMap.put("htmlURL", this.htmlURLIndex);
            this.followersIndex = getValidColumnIndex(path, table, "User", "followers");
            indicesMap.put("followers", this.followersIndex);
            this.followingIndex = getValidColumnIndex(path, table, "User", "following");
            indicesMap.put("following", this.followingIndex);
            this.publicGistsIndex = getValidColumnIndex(path, table, "User", "publicGists");
            indicesMap.put("publicGists", this.publicGistsIndex);
            this.publicReposIndex = getValidColumnIndex(path, table, "User", "publicRepos");
            indicesMap.put("publicRepos", this.publicReposIndex);
            this.repositoriesIndex = getValidColumnIndex(path, table, "User", "repositories");
            indicesMap.put("repositories", this.repositoriesIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final UserColumnInfo otherInfo = (UserColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.loginNameIndex = otherInfo.loginNameIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.emailIndex = otherInfo.emailIndex;
            this.companyIndex = otherInfo.companyIndex;
            this.avatarURLIndex = otherInfo.avatarURLIndex;
            this.htmlURLIndex = otherInfo.htmlURLIndex;
            this.followersIndex = otherInfo.followersIndex;
            this.followingIndex = otherInfo.followingIndex;
            this.publicGistsIndex = otherInfo.publicGistsIndex;
            this.publicReposIndex = otherInfo.publicReposIndex;
            this.repositoriesIndex = otherInfo.repositoriesIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final UserColumnInfo clone() {
            return (UserColumnInfo) super.clone();
        }

    }
    private UserColumnInfo columnInfo;
    private ProxyState proxyState;
    private RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("loginName");
        fieldNames.add("name");
        fieldNames.add("email");
        fieldNames.add("company");
        fieldNames.add("avatarURL");
        fieldNames.add("htmlURL");
        fieldNames.add("followers");
        fieldNames.add("following");
        fieldNames.add("publicGists");
        fieldNames.add("publicRepos");
        fieldNames.add("repositories");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    UserRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.app.testapp.data.entity.User.class, this);
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
    public String realmGet$loginName() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.loginNameIndex);
    }

    public void realmSet$loginName(String value) {
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
                throw new IllegalArgumentException("Trying to set non-nullable field 'loginName' to null.");
            }
            row.getTable().setString(columnInfo.loginNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'loginName' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.loginNameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
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
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$email() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    public void realmSet$email(String value) {
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
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$company() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.companyIndex);
    }

    public void realmSet$company(String value) {
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
                row.getTable().setNull(columnInfo.companyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.companyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.companyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.companyIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$avatarURL() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.avatarURLIndex);
    }

    public void realmSet$avatarURL(String value) {
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
                row.getTable().setNull(columnInfo.avatarURLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.avatarURLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.avatarURLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.avatarURLIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$htmlURL() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.htmlURLIndex);
    }

    public void realmSet$htmlURL(String value) {
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
                row.getTable().setNull(columnInfo.htmlURLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.htmlURLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.htmlURLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.htmlURLIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$followers() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.followersIndex);
    }

    public void realmSet$followers(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.followersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.followersIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$following() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.followingIndex);
    }

    public void realmSet$following(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.followingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.followingIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$publicGists() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.publicGistsIndex);
    }

    public void realmSet$publicGists(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.publicGistsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.publicGistsIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$publicRepos() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.publicReposIndex);
    }

    public void realmSet$publicRepos(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.publicReposIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.publicReposIndex, value);
    }

    public RealmList<com.example.app.testapp.data.entity.UserRepository> realmGet$repositories() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (repositoriesRealmList != null) {
            return repositoriesRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.repositoriesIndex);
            repositoriesRealmList = new RealmList<com.example.app.testapp.data.entity.UserRepository>(com.example.app.testapp.data.entity.UserRepository.class, linkView, proxyState.getRealm$realm());
            return repositoriesRealmList;
        }
    }

    public void realmSet$repositories(RealmList<com.example.app.testapp.data.entity.UserRepository> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("repositories")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.app.testapp.data.entity.UserRepository> original = value;
                value = new RealmList<com.example.app.testapp.data.entity.UserRepository>();
                for (com.example.app.testapp.data.entity.UserRepository item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.repositoriesIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("User")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("User");
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("loginName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("company", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("avatarURL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("htmlURL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("followers", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("following", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("publicGists", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("publicRepos", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            if (!realmSchema.contains("UserRepository")) {
                UserRepositoryRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("repositories", RealmFieldType.LIST, realmSchema.get("UserRepository")));
            return realmObjectSchema;
        }
        return realmSchema.get("User");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_User")) {
            Table table = sharedRealm.getTable("class_User");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "loginName", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "email", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "company", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "avatarURL", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "htmlURL", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "followers", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "following", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "publicGists", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "publicRepos", Table.NOT_NULLABLE);
            if (!sharedRealm.hasTable("class_UserRepository")) {
                UserRepositoryRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "repositories", sharedRealm.getTable("class_UserRepository"));
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_User");
    }

    public static UserColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_User")) {
            Table table = sharedRealm.getTable("class_User");
            final long columnCount = table.getColumnCount();
            if (columnCount != 12) {
                if (columnCount < 12) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 12 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 12 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 12 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final UserColumnInfo columnInfo = new UserColumnInfo(sharedRealm.getPath(), table);

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
            if (!columnTypes.containsKey("loginName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'loginName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("loginName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'loginName' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.loginNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'loginName' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'loginName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("email")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("email") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.emailIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'email' is required. Either set @Required to field 'email' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("company")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'company' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("company") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'company' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.companyIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'company' is required. Either set @Required to field 'company' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("avatarURL")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'avatarURL' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("avatarURL") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'avatarURL' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.avatarURLIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'avatarURL' is required. Either set @Required to field 'avatarURL' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("htmlURL")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'htmlURL' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("htmlURL") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'htmlURL' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.htmlURLIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'htmlURL' is required. Either set @Required to field 'htmlURL' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("followers")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'followers' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("followers") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'followers' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.followersIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'followers' does support null values in the existing Realm file. Use corresponding boxed type for field 'followers' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("following")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'following' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("following") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'following' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.followingIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'following' does support null values in the existing Realm file. Use corresponding boxed type for field 'following' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("publicGists")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicGists' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("publicGists") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'publicGists' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.publicGistsIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicGists' does support null values in the existing Realm file. Use corresponding boxed type for field 'publicGists' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("publicRepos")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicRepos' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("publicRepos") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'publicRepos' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.publicReposIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicRepos' does support null values in the existing Realm file. Use corresponding boxed type for field 'publicRepos' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("repositories")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'repositories'");
            }
            if (columnTypes.get("repositories") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'UserRepository' for field 'repositories'");
            }
            if (!sharedRealm.hasTable("class_UserRepository")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_UserRepository' for field 'repositories'");
            }
            Table table_11 = sharedRealm.getTable("class_UserRepository");
            if (!table.getLinkTarget(columnInfo.repositoriesIndex).hasSameSchema(table_11)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'repositories': '" + table.getLinkTarget(columnInfo.repositoriesIndex).getName() + "' expected - was '" + table_11.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'User' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_User";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.app.testapp.data.entity.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.example.app.testapp.data.entity.User obj = null;
        if (update) {
            Table table = realm.getTable(com.example.app.testapp.data.entity.User.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.app.testapp.data.entity.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("repositories")) {
                excludeFields.add("repositories");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.example.app.testapp.data.entity.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.UserRealmProxy) realm.createObjectInternal(com.example.app.testapp.data.entity.User.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("loginName")) {
            if (json.isNull("loginName")) {
                ((UserRealmProxyInterface) obj).realmSet$loginName(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$loginName((String) json.getString("loginName"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((UserRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                ((UserRealmProxyInterface) obj).realmSet$email(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("company")) {
            if (json.isNull("company")) {
                ((UserRealmProxyInterface) obj).realmSet$company(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$company((String) json.getString("company"));
            }
        }
        if (json.has("avatarURL")) {
            if (json.isNull("avatarURL")) {
                ((UserRealmProxyInterface) obj).realmSet$avatarURL(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$avatarURL((String) json.getString("avatarURL"));
            }
        }
        if (json.has("htmlURL")) {
            if (json.isNull("htmlURL")) {
                ((UserRealmProxyInterface) obj).realmSet$htmlURL(null);
            } else {
                ((UserRealmProxyInterface) obj).realmSet$htmlURL((String) json.getString("htmlURL"));
            }
        }
        if (json.has("followers")) {
            if (json.isNull("followers")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'followers' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$followers((int) json.getInt("followers"));
            }
        }
        if (json.has("following")) {
            if (json.isNull("following")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'following' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$following((int) json.getInt("following"));
            }
        }
        if (json.has("publicGists")) {
            if (json.isNull("publicGists")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'publicGists' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$publicGists((int) json.getInt("publicGists"));
            }
        }
        if (json.has("publicRepos")) {
            if (json.isNull("publicRepos")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'publicRepos' to null.");
            } else {
                ((UserRealmProxyInterface) obj).realmSet$publicRepos((int) json.getInt("publicRepos"));
            }
        }
        if (json.has("repositories")) {
            if (json.isNull("repositories")) {
                ((UserRealmProxyInterface) obj).realmSet$repositories(null);
            } else {
                ((UserRealmProxyInterface) obj).realmGet$repositories().clear();
                JSONArray array = json.getJSONArray("repositories");
                for (int i = 0; i < array.length(); i++) {
                    com.example.app.testapp.data.entity.UserRepository item = UserRepositoryRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((UserRealmProxyInterface) obj).realmGet$repositories().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.app.testapp.data.entity.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.app.testapp.data.entity.User obj = new com.example.app.testapp.data.entity.User();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("loginName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$loginName(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$loginName((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$email(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$email((String) reader.nextString());
                }
            } else if (name.equals("company")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$company(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$company((String) reader.nextString());
                }
            } else if (name.equals("avatarURL")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$avatarURL(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$avatarURL((String) reader.nextString());
                }
            } else if (name.equals("htmlURL")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$htmlURL(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$htmlURL((String) reader.nextString());
                }
            } else if (name.equals("followers")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'followers' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$followers((int) reader.nextInt());
                }
            } else if (name.equals("following")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'following' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$following((int) reader.nextInt());
                }
            } else if (name.equals("publicGists")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'publicGists' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$publicGists((int) reader.nextInt());
                }
            } else if (name.equals("publicRepos")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'publicRepos' to null.");
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$publicRepos((int) reader.nextInt());
                }
            } else if (name.equals("repositories")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((UserRealmProxyInterface) obj).realmSet$repositories(null);
                } else {
                    ((UserRealmProxyInterface) obj).realmSet$repositories(new RealmList<com.example.app.testapp.data.entity.UserRepository>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.app.testapp.data.entity.UserRepository item = UserRepositoryRealmProxy.createUsingJsonStream(realm, reader);
                        ((UserRealmProxyInterface) obj).realmGet$repositories().add(item);
                    }
                    reader.endArray();
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

    public static com.example.app.testapp.data.entity.User copyOrUpdate(Realm realm, com.example.app.testapp.data.entity.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.app.testapp.data.entity.User) cachedRealmObject;
        } else {
            com.example.app.testapp.data.entity.User realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.app.testapp.data.entity.User.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.app.testapp.data.entity.User.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.UserRealmProxy();
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

    public static com.example.app.testapp.data.entity.User copy(Realm realm, com.example.app.testapp.data.entity.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.app.testapp.data.entity.User) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.app.testapp.data.entity.User realmObject = realm.createObjectInternal(com.example.app.testapp.data.entity.User.class, ((UserRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((UserRealmProxyInterface) realmObject).realmSet$loginName(((UserRealmProxyInterface) newObject).realmGet$loginName());
            ((UserRealmProxyInterface) realmObject).realmSet$name(((UserRealmProxyInterface) newObject).realmGet$name());
            ((UserRealmProxyInterface) realmObject).realmSet$email(((UserRealmProxyInterface) newObject).realmGet$email());
            ((UserRealmProxyInterface) realmObject).realmSet$company(((UserRealmProxyInterface) newObject).realmGet$company());
            ((UserRealmProxyInterface) realmObject).realmSet$avatarURL(((UserRealmProxyInterface) newObject).realmGet$avatarURL());
            ((UserRealmProxyInterface) realmObject).realmSet$htmlURL(((UserRealmProxyInterface) newObject).realmGet$htmlURL());
            ((UserRealmProxyInterface) realmObject).realmSet$followers(((UserRealmProxyInterface) newObject).realmGet$followers());
            ((UserRealmProxyInterface) realmObject).realmSet$following(((UserRealmProxyInterface) newObject).realmGet$following());
            ((UserRealmProxyInterface) realmObject).realmSet$publicGists(((UserRealmProxyInterface) newObject).realmGet$publicGists());
            ((UserRealmProxyInterface) realmObject).realmSet$publicRepos(((UserRealmProxyInterface) newObject).realmGet$publicRepos());

            RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesList = ((UserRealmProxyInterface) newObject).realmGet$repositories();
            if (repositoriesList != null) {
                RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesRealmList = ((UserRealmProxyInterface) realmObject).realmGet$repositories();
                for (int i = 0; i < repositoriesList.size(); i++) {
                    com.example.app.testapp.data.entity.UserRepository repositoriesItem = repositoriesList.get(i);
                    com.example.app.testapp.data.entity.UserRepository cacherepositories = (com.example.app.testapp.data.entity.UserRepository) cache.get(repositoriesItem);
                    if (cacherepositories != null) {
                        repositoriesRealmList.add(cacherepositories);
                    } else {
                        repositoriesRealmList.add(UserRepositoryRealmProxy.copyOrUpdate(realm, repositoriesList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.app.testapp.data.entity.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.app.testapp.data.entity.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((UserRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$loginName = ((UserRealmProxyInterface)object).realmGet$loginName();
        if (realmGet$loginName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginNameIndex, rowIndex, realmGet$loginName, false);
        }
        String realmGet$name = ((UserRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$email = ((UserRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$company = ((UserRealmProxyInterface)object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        }
        String realmGet$avatarURL = ((UserRealmProxyInterface)object).realmGet$avatarURL();
        if (realmGet$avatarURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
        }
        String realmGet$htmlURL = ((UserRealmProxyInterface)object).realmGet$htmlURL();
        if (realmGet$htmlURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$followers(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$following(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicGists(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicRepos(), false);

        RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesList = ((UserRealmProxyInterface) object).realmGet$repositories();
        if (repositoriesList != null) {
            long repositoriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.repositoriesIndex, rowIndex);
            for (com.example.app.testapp.data.entity.UserRepository repositoriesItem : repositoriesList) {
                Long cacheItemIndexrepositories = cache.get(repositoriesItem);
                if (cacheItemIndexrepositories == null) {
                    cacheItemIndexrepositories = UserRepositoryRealmProxy.insert(realm, repositoriesItem, cache);
                }
                LinkView.nativeAdd(repositoriesNativeLinkViewPtr, cacheItemIndexrepositories);
            }
            LinkView.nativeClose(repositoriesNativeLinkViewPtr);
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.app.testapp.data.entity.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.app.testapp.data.entity.User object = null;
        while (objects.hasNext()) {
            object = (com.example.app.testapp.data.entity.User) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((UserRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$loginName = ((UserRealmProxyInterface)object).realmGet$loginName();
                if (realmGet$loginName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.loginNameIndex, rowIndex, realmGet$loginName, false);
                }
                String realmGet$name = ((UserRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$email = ((UserRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                }
                String realmGet$company = ((UserRealmProxyInterface)object).realmGet$company();
                if (realmGet$company != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
                }
                String realmGet$avatarURL = ((UserRealmProxyInterface)object).realmGet$avatarURL();
                if (realmGet$avatarURL != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
                }
                String realmGet$htmlURL = ((UserRealmProxyInterface)object).realmGet$htmlURL();
                if (realmGet$htmlURL != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$followers(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$following(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicGists(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicRepos(), false);

                RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesList = ((UserRealmProxyInterface) object).realmGet$repositories();
                if (repositoriesList != null) {
                    long repositoriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.repositoriesIndex, rowIndex);
                    for (com.example.app.testapp.data.entity.UserRepository repositoriesItem : repositoriesList) {
                        Long cacheItemIndexrepositories = cache.get(repositoriesItem);
                        if (cacheItemIndexrepositories == null) {
                            cacheItemIndexrepositories = UserRepositoryRealmProxy.insert(realm, repositoriesItem, cache);
                        }
                        LinkView.nativeAdd(repositoriesNativeLinkViewPtr, cacheItemIndexrepositories);
                    }
                    LinkView.nativeClose(repositoriesNativeLinkViewPtr);
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.app.testapp.data.entity.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.app.testapp.data.entity.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((UserRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$loginName = ((UserRealmProxyInterface)object).realmGet$loginName();
        if (realmGet$loginName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginNameIndex, rowIndex, realmGet$loginName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.loginNameIndex, rowIndex, false);
        }
        String realmGet$name = ((UserRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$email = ((UserRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$company = ((UserRealmProxyInterface)object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
        }
        String realmGet$avatarURL = ((UserRealmProxyInterface)object).realmGet$avatarURL();
        if (realmGet$avatarURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, false);
        }
        String realmGet$htmlURL = ((UserRealmProxyInterface)object).realmGet$htmlURL();
        if (realmGet$htmlURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$followers(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$following(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicGists(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicRepos(), false);

        long repositoriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.repositoriesIndex, rowIndex);
        LinkView.nativeClear(repositoriesNativeLinkViewPtr);
        RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesList = ((UserRealmProxyInterface) object).realmGet$repositories();
        if (repositoriesList != null) {
            for (com.example.app.testapp.data.entity.UserRepository repositoriesItem : repositoriesList) {
                Long cacheItemIndexrepositories = cache.get(repositoriesItem);
                if (cacheItemIndexrepositories == null) {
                    cacheItemIndexrepositories = UserRepositoryRealmProxy.insertOrUpdate(realm, repositoriesItem, cache);
                }
                LinkView.nativeAdd(repositoriesNativeLinkViewPtr, cacheItemIndexrepositories);
            }
        }
        LinkView.nativeClose(repositoriesNativeLinkViewPtr);

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.app.testapp.data.entity.User.class);
        long tableNativePtr = table.getNativeTablePointer();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.schema.getColumnInfo(com.example.app.testapp.data.entity.User.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.app.testapp.data.entity.User object = null;
        while (objects.hasNext()) {
            object = (com.example.app.testapp.data.entity.User) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((UserRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((UserRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((UserRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$loginName = ((UserRealmProxyInterface)object).realmGet$loginName();
                if (realmGet$loginName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.loginNameIndex, rowIndex, realmGet$loginName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.loginNameIndex, rowIndex, false);
                }
                String realmGet$name = ((UserRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$email = ((UserRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
                }
                String realmGet$company = ((UserRealmProxyInterface)object).realmGet$company();
                if (realmGet$company != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
                }
                String realmGet$avatarURL = ((UserRealmProxyInterface)object).realmGet$avatarURL();
                if (realmGet$avatarURL != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, realmGet$avatarURL, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.avatarURLIndex, rowIndex, false);
                }
                String realmGet$htmlURL = ((UserRealmProxyInterface)object).realmGet$htmlURL();
                if (realmGet$htmlURL != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, realmGet$htmlURL, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.htmlURLIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.followersIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$followers(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.followingIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$following(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.publicGistsIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicGists(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.publicReposIndex, rowIndex, ((UserRealmProxyInterface)object).realmGet$publicRepos(), false);

                long repositoriesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.repositoriesIndex, rowIndex);
                LinkView.nativeClear(repositoriesNativeLinkViewPtr);
                RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesList = ((UserRealmProxyInterface) object).realmGet$repositories();
                if (repositoriesList != null) {
                    for (com.example.app.testapp.data.entity.UserRepository repositoriesItem : repositoriesList) {
                        Long cacheItemIndexrepositories = cache.get(repositoriesItem);
                        if (cacheItemIndexrepositories == null) {
                            cacheItemIndexrepositories = UserRepositoryRealmProxy.insertOrUpdate(realm, repositoriesItem, cache);
                        }
                        LinkView.nativeAdd(repositoriesNativeLinkViewPtr, cacheItemIndexrepositories);
                    }
                }
                LinkView.nativeClose(repositoriesNativeLinkViewPtr);

            }
        }
    }

    public static com.example.app.testapp.data.entity.User createDetachedCopy(com.example.app.testapp.data.entity.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.app.testapp.data.entity.User unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.app.testapp.data.entity.User)cachedObject.object;
            } else {
                unmanagedObject = (com.example.app.testapp.data.entity.User)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.app.testapp.data.entity.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((UserRealmProxyInterface) unmanagedObject).realmSet$id(((UserRealmProxyInterface) realmObject).realmGet$id());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$loginName(((UserRealmProxyInterface) realmObject).realmGet$loginName());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$name(((UserRealmProxyInterface) realmObject).realmGet$name());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$email(((UserRealmProxyInterface) realmObject).realmGet$email());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$company(((UserRealmProxyInterface) realmObject).realmGet$company());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$avatarURL(((UserRealmProxyInterface) realmObject).realmGet$avatarURL());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$htmlURL(((UserRealmProxyInterface) realmObject).realmGet$htmlURL());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$followers(((UserRealmProxyInterface) realmObject).realmGet$followers());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$following(((UserRealmProxyInterface) realmObject).realmGet$following());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$publicGists(((UserRealmProxyInterface) realmObject).realmGet$publicGists());
        ((UserRealmProxyInterface) unmanagedObject).realmSet$publicRepos(((UserRealmProxyInterface) realmObject).realmGet$publicRepos());

        // Deep copy of repositories
        if (currentDepth == maxDepth) {
            ((UserRealmProxyInterface) unmanagedObject).realmSet$repositories(null);
        } else {
            RealmList<com.example.app.testapp.data.entity.UserRepository> managedrepositoriesList = ((UserRealmProxyInterface) realmObject).realmGet$repositories();
            RealmList<com.example.app.testapp.data.entity.UserRepository> unmanagedrepositoriesList = new RealmList<com.example.app.testapp.data.entity.UserRepository>();
            ((UserRealmProxyInterface) unmanagedObject).realmSet$repositories(unmanagedrepositoriesList);
            int nextDepth = currentDepth + 1;
            int size = managedrepositoriesList.size();
            for (int i = 0; i < size; i++) {
                com.example.app.testapp.data.entity.UserRepository item = UserRepositoryRealmProxy.createDetachedCopy(managedrepositoriesList.get(i), nextDepth, maxDepth, cache);
                unmanagedrepositoriesList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.example.app.testapp.data.entity.User update(Realm realm, com.example.app.testapp.data.entity.User realmObject, com.example.app.testapp.data.entity.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((UserRealmProxyInterface) realmObject).realmSet$loginName(((UserRealmProxyInterface) newObject).realmGet$loginName());
        ((UserRealmProxyInterface) realmObject).realmSet$name(((UserRealmProxyInterface) newObject).realmGet$name());
        ((UserRealmProxyInterface) realmObject).realmSet$email(((UserRealmProxyInterface) newObject).realmGet$email());
        ((UserRealmProxyInterface) realmObject).realmSet$company(((UserRealmProxyInterface) newObject).realmGet$company());
        ((UserRealmProxyInterface) realmObject).realmSet$avatarURL(((UserRealmProxyInterface) newObject).realmGet$avatarURL());
        ((UserRealmProxyInterface) realmObject).realmSet$htmlURL(((UserRealmProxyInterface) newObject).realmGet$htmlURL());
        ((UserRealmProxyInterface) realmObject).realmSet$followers(((UserRealmProxyInterface) newObject).realmGet$followers());
        ((UserRealmProxyInterface) realmObject).realmSet$following(((UserRealmProxyInterface) newObject).realmGet$following());
        ((UserRealmProxyInterface) realmObject).realmSet$publicGists(((UserRealmProxyInterface) newObject).realmGet$publicGists());
        ((UserRealmProxyInterface) realmObject).realmSet$publicRepos(((UserRealmProxyInterface) newObject).realmGet$publicRepos());
        RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesList = ((UserRealmProxyInterface) newObject).realmGet$repositories();
        RealmList<com.example.app.testapp.data.entity.UserRepository> repositoriesRealmList = ((UserRealmProxyInterface) realmObject).realmGet$repositories();
        repositoriesRealmList.clear();
        if (repositoriesList != null) {
            for (int i = 0; i < repositoriesList.size(); i++) {
                com.example.app.testapp.data.entity.UserRepository repositoriesItem = repositoriesList.get(i);
                com.example.app.testapp.data.entity.UserRepository cacherepositories = (com.example.app.testapp.data.entity.UserRepository) cache.get(repositoriesItem);
                if (cacherepositories != null) {
                    repositoriesRealmList.add(cacherepositories);
                } else {
                    repositoriesRealmList.add(UserRepositoryRealmProxy.copyOrUpdate(realm, repositoriesList.get(i), true, cache));
                }
            }
        }
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
        UserRealmProxy aUser = (UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
