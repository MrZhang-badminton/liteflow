/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.getChainName.cmp;

import com.yomahub.liteflow.core.NodeSwitchComponent;
import com.yomahub.liteflow.slot.DefaultContext;

public class HCmp extends NodeSwitchComponent {

	@Override
	public String processSwitch() throws Exception {
		DefaultContext context = this.getFirstContextBean();
		context.setData(this.getNodeId(), this.getCurrChainName());
		return "j";
	}

}
