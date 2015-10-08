/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wltea.analyzer.lucene;

import org.apache.lucene.analysis.Analyzer;

/**
 * IK分词器，Lucene Analyzer接口实现 兼容Lucene 4.0版本
 */
public final class IKAnalyzer extends Analyzer {

	/**
	 * 是否启用智能分词模式。
	 */
	private boolean useSmart;

	public boolean getUseSmart() {
		return useSmart;
	}

	public void setUseSmart(boolean useSmart) {
		this.useSmart = useSmart;
	}

	/**
	 * IK分词器Lucene Analyzer接口实现类
	 * 
	 * 默认细粒度切分算法
	 */
	public IKAnalyzer() {
		this(false);
	}

	/**
	 * IK分词器Lucene Analyzer接口实现类
	 * 
	 * @param useSmart
	 *            当为true时，分词器进行智能切分
	 */
	public IKAnalyzer(boolean useSmart) {
		this.useSmart = useSmart;
	}

	/**
	 * 重载Analyzer接口，构造分词组件
	 */
	@Override
	protected TokenStreamComponents createComponents(String arg0) {
		return new TokenStreamComponents(new IKTokenizer(this.getUseSmart()));
	}

}
