/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.program.model.data;

/**
 * Basic implementation for a Short Integer dataType 
 */
public class ShortDataType extends AbstractIntegerDataType {

	private final static long serialVersionUID = 1;

	/** A statically defined ShortDataType instance.*/
	public final static ShortDataType dataType = new ShortDataType();

	public ShortDataType() {
		this(null);
	}

	public ShortDataType(DataTypeManager dtm) {
		super("short", true, dtm);
	}

	/**
	 * @see ghidra.program.model.data.DataType#getLength()
	 */
	@Override
	public int getLength() {
		return getDataOrganization().getShortSize();
	}

	/**
	 * @see ghidra.program.model.data.DataType#hasLanguageDependantLength()
	 */
	@Override
	public boolean hasLanguageDependantLength() {
		return true;
	}

	/**
	 * 
	 * @see ghidra.program.model.data.DataType#getDescription()
	 */
	@Override
	public String getDescription() {
		return "Signed Short Integer (compiler-specific size)";
	}

	@Override
	public String getCDeclaration() {
		return C_SIGNED_SHORT;
	}

	@Override
	public UnsignedShortDataType getOppositeSignednessDataType() {
		return UnsignedShortDataType.dataType.clone(getDataTypeManager());
	}

	@Override
	public ShortDataType clone(DataTypeManager dtm) {
		if (dtm == getDataTypeManager()) {
			return this;
		}
		return new ShortDataType(dtm);
	}

	@Override
	public String getCTypeDeclaration(DataOrganization dataOrganization) {
		return null; // standard C-primitive name and type
	}

}
