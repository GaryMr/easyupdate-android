package com.gary.android.easyupdate;

/**
 * 配置
 */
public final class EasyUpdateConfig {

    private final boolean updateOnlyWifi;
    private final boolean deltaUpdate;
    private final boolean updateAutoPopup;
    private final EasyUpdatePlugin updatePlugin;

    private EasyUpdateConfig(Builder builder) {
        updateOnlyWifi = builder.updateOnlyWifi;
        deltaUpdate = builder.deltaUpdate;
        updatePlugin = builder.updatePlugin;
        updateAutoPopup = builder.updateAutoPopup;
    }

    public EasyUpdatePlugin getUpdatePlugin() {
        return updatePlugin;
    }

    public boolean isUpdateOnlyWifi() {
        return updateOnlyWifi;
    }

    public boolean isDeltaUpdate() {
        return deltaUpdate;
    }

    public boolean isUpdateAutoPopup() {
        return updateAutoPopup;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private boolean updateOnlyWifi = true;
        private boolean deltaUpdate = false;
        private boolean updateAutoPopup = true;
        private EasyUpdatePlugin updatePlugin;

        /**
         * 设置更新的网络条件
         * @param updateOnlyWifi 布尔值true(默认)只在wifi环境下检测更新，false在所有网络环境中均检测更新。
         */
        public Builder setUpdateOnlyWifi(boolean updateOnlyWifi) {
            this.updateOnlyWifi = updateOnlyWifi;
            return this;
        }

        /**
         * 设置增量更新
         * @param deltaUpdate 布尔值true(默认)使用增量更新，false使用全量更新。
         */
        public Builder setDeltaUpdate(boolean deltaUpdate) {
            this.deltaUpdate = deltaUpdate;
            return this;
        }

        /**
         * 如果自己处理更新回调，选择自己对用户进行更新提示，请关闭自动弹出提示，避免重复弹出提示
         * @param updateAutoPopup 布尔值true(默认)自动弹出更新提示的对话框/通知栏，false禁止弹出更新提示的对话框/通知栏。
         * @return
         */
        public Builder setUpdateAutoPopup(boolean updateAutoPopup) {
            this.updateAutoPopup = updateAutoPopup;
            return this;
        }

        /**
         * 设置检查更新的插件
         * @param updatePlugin
         */
        public Builder setUpdatePlugin(EasyUpdatePlugin updatePlugin) {
            this.updatePlugin = updatePlugin;
            return this;
        }

        public EasyUpdateConfig build() {
            return new EasyUpdateConfig(this);
        }
    }
}
